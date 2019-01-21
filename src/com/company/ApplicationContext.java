package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext {
    private Map<String, Object> components;
    private Properties properties;

    private static ApplicationContext context;

    private ApplicationContext() {
        components = new HashMap<>();
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources\\application.properties"));

            Class<Check> checkClass = (Class<Check>) Class.forName(properties.getProperty("check.class"));
            //по полному имени класса получаем объект класса (для этого вызываем класс класса Class)
            Class<Taxi> taxiClass = (Class<Taxi>) Class.forName(properties.getProperty("taxi.class"));

            Double km = Double.parseDouble(properties.getProperty("taxi.km"));
            Check check = checkClass.newInstance();

            Constructor<Taxi> taxiConstructor = taxiClass.getConstructor(double.class, Check.class);

            Taxi taxi = taxiConstructor.newInstance(km, check);

            components.put("check", check);
            components.put("taxi", taxi);
        } catch (IOException | ReflectiveOperationException e) {
                throw new IllegalStateException(e);
        }
    }

    static {
        context = new ApplicationContext();
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public <T> T getComponent(Class<T> aClass, String componentName) {
        Object component =  components.get(componentName);
        return (T)component;
    }
}



    /*Dependency injection
    Внедрение зависимостей — это стиль настройки объекта, при котором поля объекта задаются внешней сущностью.
    Другими словами, объекты настраиваются внешними объектами.
    DI — это альтернатива самонастройке объектов.
*/
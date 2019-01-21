package com.company;

//Написать ApplicationContext.
//Данный контекст принимает на вход названия пакетов, где хранятся компоненты (например сервисы и репозитории)
//
//Компонент загружает данные классы в свой список, а далее их соединяет при необходимости и выдает пользователю.
//
//Также контекст может принимать компоненты извне.
//
//ApplicationContext context = Contexts.componentsBased();
//
//UsersService service = context.getComponent(UsersService.class); // получаете сервис со всеми проставленными зависимостями.
//
//Алгоритм решения:
//
//Получаете список классов. Смотрите, какие у них конструкторы и какие там указаны типы. Далее, анализируя эти типы объединяете компоненты.


public class Main {

    public static void main(String[] args) {
        Taxi taxi = ApplicationContext.getContext().getComponent(Taxi.class, "taxi");
        taxi.price(10);
    }
}

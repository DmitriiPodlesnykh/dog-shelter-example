# dog-shelter-example
![Java CI with Gradle](https://github.com/DmitriiPodlesnykh/dog-shelter-example/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)

## Запуск проекта:
1. Открыть панель Gradle в Idea: View -> Tool Windows -> Gradle
1. В открывшимся окне развернуть dog-shelter-example -> tasks -> application -> run
1. запустить run

##Подключение к БД из консоли:
1. [Информация для intellij idea community edition](https://www.jetbrains.com/help/idea/connecting-to-a-database.html#connect-to-postgresql-database)
1. [Информация для intellij idea community edition](https://plugins.jetbrains.com/plugin/1800-database-navigator)
1. Данные(Могут меняться, пишите если не получается подключиться):

| **Название поля** | **Значение**      |
| ------------------|:-----------------:|
| Host              | `ec2-54-247-78-30.eu-west-1.compute.amazonaws.com` |
| Port              | `5432`      |
| User              | `xgelkpgtivsuvf`     |
| Password          | `facd5537e5c673703e283c3a3728b73da206fbb123cef8bf310d2bee7d7c6202`|
| DataBase          | `d91lfd343lpk2a`|
| URL               | `jdbc:postgresql://ec2-54-247-78-30.eu-west-1.compute.amazonaws.com:5432/d91lfd343lpk2a`|

# История занятий

## 05.08.2020
1. Полиморфизм

### Что почитать:
1. [Небольшое видео о полиморфизме](https://www.youtube.com/watch?v=Ay_GwOQWPs8&t=413s)
1. [Пример использования полиморфизма](https://www.w3schools.com/java/java_polymorphism.asp)

## 28.07.2020
1. Наследование

### Что почитать:
1. [Небольшое видео о наследовании](https://www.youtube.com/watch?v=eI0XzQw3V0Q)
1. [Общая статья](https://www.geeksforgeeks.org/inheritance-in-java/)
1. [Разные способы наследования с примерами](https://www.javatpoint.com/inheritance-in-java)
1. [Правила наследования](https://vertex-academy.com/tutorials/ru/pravila-nasledovaniya-v-java)

## 25.07.2020
1. Инкапсуляция
1. Пару слов о сериализации

### Что почитать:
1. [Небольшое видео об инкапсуляции](https://www.youtube.com/watch?v=EvGi6XDgV7w&t=339s)
1. [getters/setters](https://www.w3schools.com/java/java_encapsulation.asp)
1. [Более общая статья с примерами](https://vertex-academy.com/tutorials/ru/inkapsulyaciya-java/)
1. [Факультативно сериализация](https://javarush.ru/groups/posts/2022-serializacija-i-deserializacija-v-java)

## 14.07.2020-16.07.2020
Сделали приложение, которое можно запустить в браузере http://localhost:7000/

### Что почитать:
1. [Javelin documentation](https://javalin.io/documentation#getting-started)
1. [Javelin example](https://www.baeldung.com/javalin-rest-microservices)
1. [Javelin передача параметров в строке браузера](https://javalin.io/documentation#endpoint-handlers)
1. [Функциональный интерфейс](https://javarush.ru/groups/posts/592-java-functional-interfaces)

### Рекомендуется выполнить:
1. При вызове <code>/dogs/full</code> возвращать всю информацию обо всех собаказ из БД
1. При вызове <code>/statuses</code> возвращать список всех возможных статусов для собак(не ходить в БД)
1. При вызове строки <code>/statuses/{статус какой-то из DogStatus}</code> - выводить список собак с таким статусом.
Постараться создать новый Handler
1. При вызове строки <code>/statuses/statistics</code> вывести строку в которой перечисленны
 все статусы DogStatus в формате <code>"статус такой-то" used "столько-то раз;......"</code>


## 08.07.2020
Вспомнили и применили на практике интерфейсы.

### Что почитать:
1. [Правила именования переменных, констант, классов, интерфейсов, перечислений, пакетов в Java](https://khasang.io/courses/cleancode/lectures/4428018)
1. [Интерфейсы](https://javarush.ru/groups/posts/1981-dlja-chego-v-java-nuzhnih-interfeysih)
1. [What is Interface in Java with Example](https://www.guru99.com/java-interface.html#:~:text=Java%20uses%20Interface%20to%20implement,are%20implicitly%20public%20and%20abstract.&text=To%20use%20an%20interface%20in,followed%20by%20the%20interface%20name.)

### Рекомендуется выполнить:
1. Создать класс в пакете com.example.shelter.db.dogs.update
1. Имплементировать интерфейс DogUpdateDataAccess для созданного класса
1. Реализовать методы

## 30.06.2020-02.07.2020
### Что было:
1. Реализовали возможность добавлять данные в БД. [Statement/Prepared statement](https://metanit.com/java/database/2.6.php)

### Что почитать:
1. [Try with resources](https://www.baeldung.com/java-try-with-resources)
1. [Closing Database Connections in Java](https://stackoverflow.com/questions/2225221/closing-database-connections-in-java)
1. [Исключения в Java](https://javarush.ru/groups/posts/isklyucheniya-java)

### Рекомендуется выполнить:
реализовать и проверить метод com.example.shelter.db.DogInsertDataAccess.addNewDogs(List<Dog> dogs)

## 23.06.2020
### Что было:

* Собрали и запустили проект используя Gradle.
* JDBC
* Получили данные из внешней БД

### Что почитать:
1. [JDBC или с чего всё начинается](https://javarush.ru/groups/posts/2172-jdbc-ili-s-chego-vsje-nachinaetsja)
1. Факультативно [Инструменты для сборки проекта, включая абзац про Gradle](https://javarush.ru/groups/posts/2318-kompiljacija-v-java)
### Рекомендуется выполнить:
Собрать и запустить проект коммандой <code>dog-shelter-example:tasks:application:run</code>
Реализовать методы:
1. <code>ShelterDataAccess.getAllDogNames()</code>
1. <code>ShelterDataAccess.getUniqueDogNames()</code>
1. <code>ShelterDataAccess.getAllDogs()</code>

## 16.06.2020
### Что почитать:
1. [Что такое ООП](https://www.youtube.com/watch?v=M58eiYbM6AE)
1. [Инкапсуляция](https://www.youtube.com/watch?v=EvGi6XDgV7w)
1. [Наследование](https://www.youtube.com/watch?v=eI0XzQw3V0Q)
1. [Полиморфизм](https://www.youtube.com/watch?v=Ay_GwOQWPs8)

## 09.06.2020
### Что было:
Отвели ветки от master branch. Попробовали merge.

### Что почитать:
1. https://www.jetbrains.com/help/idea/apply-changes-from-one-branch-to-another.html Только про merge
1. https://www.jetbrains.com/help/idea/resolving-conflicts.html Resolve conflicts

### Рекомендуется выполнить:
1. Создать именную ветку от master branch, если такой еще нет. 
Сделать merge master branch в свою локальную ветку, если ветка была. 
1. Дополнительно: Добавить новое поле в объект Dog, - дата появления(java.time.LocalDateTime), статус('Принят', 'Не принят', 'Выписан').
 Переопределить метод toString с учетом этого поля.
 Заполнять поле из консоли или если пользователь не заполняет значения - сохранять текущее время 
 ( https://www.baeldung.com/java-8-date-time-intro )
 ( https://www.javatpoint.com/java-localdate )
1. Дополнительно: Добавить новое поле в объект Dog - статус('Принят', 'Не принят', 'Выписан').
Переопределить метод toString с учетом этого поля.
 Заполнять поле из консоли или если пользователь не заполняет значения - сохранить статус 'Принят'.
Статус может быть как строкой, так и структурой данных Enum. Подробнее об Enum:
 ( https://www.youtube.com/watch?v=GOzNp1YAm5w )
 ( https://www.baeldung.com/a-guide-to-java-enums)

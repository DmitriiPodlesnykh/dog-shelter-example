# dog-shelter-example
![Java CI with Gradle](https://github.com/DmitriiPodlesnykh/dog-shelter-example/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)

Запуск проекта:
1. Открыть панель Gradle в Idea: View -> Tool Windows -> Gradle
1. В открывшимся окне развернуть dog-shelter-example -> tasks -> application -> run
1. запустить run

## 30.06.2020

### Что почитать:
1. [Try with resources](https://www.baeldung.com/java-try-with-resources)
1. [Closing Database Connections in Java](https://stackoverflow.com/questions/2225221/closing-database-connections-in-java)
1. [Исключения в Java](https://javarush.ru/groups/posts/isklyucheniya-java)


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

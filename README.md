# dog-shelter-example
![Java CI with Gradle](https://github.com/DmitriiPodlesnykh/dog-shelter-example/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)

Точка входа 
<code>dog-shelter-example-main/src/main/java/com/example/shelter/Main.java</code>

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
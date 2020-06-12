# dog-shelter-example
![Java CI with Gradle](https://github.com/DmitriiPodlesnykh/dog-shelter-example/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)

Точка входа 
<code>dog-shelter-example-main/src/main/java/com/example/shelter/Main.java</code>


## 09.06.2020 - 11.06.2020
### Что было:
Отвели ветки от master branch. Попробовали merge.
Создали функционал добавления объектов Dog из консоли. С выбором имени

### Что почитать:
1. https://www.jetbrains.com/help/idea/apply-changes-from-one-branch-to-another.html Только про merge
1. https://www.jetbrains.com/help/idea/resolving-conflicts.html Resolve conflicts

### Рекомендуется выполнить:
1. Создать именную ветку от master branch, если такой еще нет. 
Сделать merge master branch в свою локальную ветку, если ветка была. 
2. Дополнительно: Добавить новые 2 поля в объект Dog, - дата появления(java.time.LocalDateTime), статус('Принят', 'Не принят', 'Выписан').
 Переопределить метод toString с учетом этих полей.
 Заполнять поля из консоли или если пользователь не заполняет значения - сохранять текущее время и статус 'Принят'.
Работа с датами 
* https://www.baeldung.com/java-8-date-time-intro, 
* https://www.javatpoint.com/java-localdate

Статус может быть как строкой, так и структурой данных Enum. Подробнее об Enum:
* https://www.youtube.com/watch?v=GOzNp1YAm5w
* https://www.baeldung.com/a-guide-to-java-enums

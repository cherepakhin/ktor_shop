# Prompts

1. `/usr/lib/jvm/jdk-21.0.2/bin/java ... SLF4J: Failed to load class ...` — запуск тестов с предупреждением SLF4J
2. `исправь для java 11` — переключить на Java 11 и logback 1.4
3. `заменить версию в nexus, даже если существует` — настройка перезаписи артефактов в Nexus
4. `сделай mapper в JSON и из JSON` — переписать MapperProductToJson с использованием Jackson
5. `напиши unit test` — создать тесты для MapperProduct
6. `сделай его Object` — преобразовать класс в object (синглтон)
7. `переделай MapperProduct в object` — то же самое для MapperProduct
8. `проверь MapperProduct` — проверить корректность MapperProduct
9. `найди места непокрытые тестами` — анализ покрытия тестами
10. `зачем plugin configureSerialization` — вопрос о назначении плагина сериализации
11. `воссоздать` — воссоздать удалённый Serialization.kt
12. `jacoco работает с kotlin?` — вопрос о поддержке JaCoCo для Kotlin
13. `да` — добавить JaCoCo в проект
14. `добавь инструкции для jacoco в Readme` — документация JaCoCo
15. `commit` — закоммитить изменения
16. `вынеси http запросы для product в отдельный класс` — извлечь ProductRepository
17. `commit` — закоммитить ProductRepository
18. `routing для product тоже в отдельный класс` — создать ProductRouting plugin
19. `commit` — закоммитить ProductRouting
20. `тоже самое для User` — извлечь UserRouting plugin
21. `commit` — закоммитить UserRouting
22. `исправь тесты` — исправить тесты после рефакторинга
23. `commit` — закоммитить исправления тестов
24. `тесты для route User перенеси в отдельный класс` — создать UserRoutingTest
25. `commit` — закоммитить UserRoutingTest
26. `нет commit для UserRoutingTest` — уточнение
27. `да` — push в origin
28. `нет. сам сделал` — пользователь сделал push самостоятельно
29. `сделай тест для ProductRouting` — создать ProductRoutingTest
30. `commit` — закоммитить ProductRoutingTest
31. `добавь entity Product` — создать сущность Product с полями description и price

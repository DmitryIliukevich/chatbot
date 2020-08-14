# chatbot
Веб приложение по управлению своим туристическим ботом.

# Для запуска необходимо:
1. Установить базу MySql и выполнить скрипт ../chatbot/src/main/recources/script.sgl
2. Скачать проект из GitHub https://github.com/DmitryIliukevich/chatbot.git
3. Собрать проект с помощью Maven (mvn clean package)
4. Запуситить проект из папки ../chatbot/target используя команду java -jar chatbot-0.0.1-SNAPSHOT.jar
5. Запусить в баузере web приложение по адресу http://localhost:8080/
6  Создать записи в базе данных через web приложение. Для этого необходимо зайти на страницу 
   http://localhost:8080/new и добавить города(например: Москва, посетите Красную площадь)
7  Найти в телеграмме чат бот по имени SimpleTouristChatBot
8  Отправить сообщение (например: Москва).
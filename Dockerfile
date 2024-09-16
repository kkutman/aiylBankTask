# Используем базовый образ с OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем JAR-файл вашего приложения в рабочую директорию
COPY target/your-app.jar /app/your-app.jar

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "/app/your-app.jar"]

# Открываем порт, на котором приложение будет работать
EXPOSE 8080

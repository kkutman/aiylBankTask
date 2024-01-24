АЙЫЛ БАНК ТЕСТОВОЕ ЗАДАНИЕ!

Инструкции по развертыванию и запуску приложения

1. Клонирование репозитория:
   git clone https://github.com/kkutman/aiylBankTask.git
      cd your-todo-app

2. Конфигурация базы данных:
   Отредактируйте файл src/main/resources/application.properties 
   и укажите параметры вашей базы данных:
 
   ------------------------------------------------------------------
   spring.datasource.url=jdbc:postgresql://localhost:5432/aiyl_bank
     spring.datasource.password=postgres
     spring.datasource.username=postgres
     spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
     spring.jpa.hibernate.ddl-auto=none
     spring.jpa.show-sql=true
     server.port=8080
     server.error.include-message=always

   #flyway
   spring.flyway.enabled=true
     spring.flyway.baseline-on-migrate=true
     spring.flyway.locations=classpath:db/migration

3. Сборка проекта: 
   Выполните сборку проекта с использованием Maven: mvn clean install

4. Swagger документация:
   После запуска приложения, вы можете посмотреть
   Swagger документацию по адресу http://localhost:8080/swagger-ui/.










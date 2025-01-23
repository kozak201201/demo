# Используем официальный образ OpenJDK 21
FROM openjdk:21-jdk-slim as build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл Gradle
COPY . .

# Строим приложение
RUN ./gradlew build -x test

# Используем JAR файл из build/libs
FROM openjdk:21-jdk-slim

WORKDIR /app

# Копируем скомпилированный JAR файл в контейнер
COPY --from=build /app/build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar

# Запуск приложения
ENTRYPOINT ["java", "-jar", "demo.jar"]

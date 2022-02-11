# 1. node 설치
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/app.jar
# 2. 소스 복사
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar","/app.jar" ]
EXPOSE 80
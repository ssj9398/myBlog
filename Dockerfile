# 1. node 설치
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/pro-0.0.1-SNAPSHOT.jar
# 2. 소스 복사
COPY ${JAR_FILE} pro-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar","/pro-0.0.1-SNAPSHOT.jar" ]
EXPOSE 80
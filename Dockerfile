FROM openjdk:21-jdk-slim
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"
COPY build/libs/app.jar /dev/app.jar
WORKDIR /dev
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
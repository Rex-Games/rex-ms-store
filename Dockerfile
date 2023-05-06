FROM eclipse-temurin:17-jdk-jammy as builder

WORKDIR /app/builder/

COPY . .

RUN ./gradlew assemble

FROM eclipse-temurin:17-jre-jammy as release

WORKDIR /app

RUN addgroup runner; adduser  --ingroup runner --disabled-password runner
USER runner

COPY --from=builder /app/builder/build/libs/*.jar app.jar

EXPOSE 8080

VOLUME /app/logs

ENTRYPOINT ["java","-jar","app.jar"]
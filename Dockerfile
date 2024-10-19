FROM gradle:7.5.1 as base

WORKDIR /app

COPY . .

# RUN ./gradlew build

CMD ./gradlew run

FROM base AS prod
ENTRYPOINT ./gradlew run --console=plain

FROM base AS test
ENTRYPOINT ./gradlew test --console=plain
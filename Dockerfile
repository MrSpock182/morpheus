FROM container-registry.oracle.com/graalvm/native-image:23-ol8 AS builder

WORKDIR /build

COPY . /build

COPY src/main/resources/META-INF/native-image /build/target/META-INF/native-image

RUN ./mvnw --no-transfer-progress native:compile -Pnative

FROM gcr.io/distroless/java-base-debian12

EXPOSE 8080

COPY --from=builder /build/target/morpheus /app

ENTRYPOINT ["/app"]
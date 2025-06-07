FROM openjdk:17

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado
COPY "./target/ProyectoCarpooling-0.0.1-SNAPSHOT.jar" "app.jar"

# Exponer el puerto que usará la aplicación
EXPOSE 8122

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
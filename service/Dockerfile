FROM eclipse-temurin:21-jre-alpine

# Opcional: mostrar versión
RUN java -version

# Opcional: argumentos de Java
ENV JAVA_OPTS=""

# Copiamos el jar
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar

# Copiamos el script y damos permisos
COPY appshell.sh /appshell.sh
RUN chmod +x /appshell.sh

# Puerto según application.properties
EXPOSE 7080

ENTRYPOINT ["sh", "/appshell.sh"]

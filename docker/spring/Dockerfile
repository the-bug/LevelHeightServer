FROM openjdk:11

# Copy 
# ARG JAR_FILE
# COPY ${JAR_FILE} app.jar
COPY ./build/server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

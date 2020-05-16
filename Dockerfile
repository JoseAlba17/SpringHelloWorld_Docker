#Descargamos una imagen con maven de la versión señalada y Java
FROM maven:3.6.3-jdk-8

#Haciendo la copia de todos los archivos de la aplicación a una carpeta con el myapp del contenedor
COPY . /myapp

#Moverme a la carpeta myapp
WORKDIR /myapp

#Correr el comando de maven para construir la aplicación
RUN mvn clean package

#Mover y renombrar archivo jar
RUN mv /myapp/target/*.jar /myapp/myapp.jar

#Intrucciones para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/myapp/myapp.jar"]

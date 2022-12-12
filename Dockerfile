FROM openjdk:17
EXPOSE 8080
ADD target/yoga-class.jar yoga-class.jar
ENTRYPOINT {"java","-jar","/yoga-class.jar"}
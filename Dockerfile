FROM openjdk:8
EXPOSE 7777
ADD target/newHotel.jar newHotel.jar
ENTRYPOINT [ "java", "-jar", "/newHotel.jar" ]
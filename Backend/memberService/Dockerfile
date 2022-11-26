FROM openjdk:8
EXPOSE 8004
ADD target/memberService-0.0.1-SNAPSHOT.jar memberapp.jar
ENTRYPOINT ["java","-jar","/memberapp.jar"]
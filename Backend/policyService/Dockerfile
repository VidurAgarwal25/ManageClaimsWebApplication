FROM openjdk:8
EXPOSE 8002
ADD target/PolicyMicroservice-0.0.1-SNAPSHOT.jar policyapp.jar
ENTRYPOINT ["java","-jar","/policyapp.jar"]
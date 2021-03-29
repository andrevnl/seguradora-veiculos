FROM java:8
VOLUME /tmp
ADD target/seguradora-veiculos-0.0.1-SNAPSHOT.war appSeguradoraVeiculosAndrevnl.war
EXPOSE 8080
RUN sh -c 'touch /appSeguradoraVeiculosAndrevnl.war'
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongocontainer/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/appSeguradoraVeiculosAndrevnl.war"]

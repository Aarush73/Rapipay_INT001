FROM openjdk:11
ADD target/otp-api-docker.jar otp-api-docker.jar
ENTRYPOINT ["java", "-jar","otp-api-docker.jar"]
EXPOSE 8070

#FROM kong:1.2rc1-centos
#COPY kong.yml /
#RUN cp /etc/kong/kong.conf.default /etc/kong/kong.conf
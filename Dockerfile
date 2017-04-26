# Apache Tomcat image with build artifact

FROM tomcat:8.5.14-jre8
MAINTAINER Gary A. Stafford <garystafford@rochester.rr.com>
ENV REFRESHED_AT 2016-09-17

ADD target/dockerjava-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

ENV TERM xterm
ENV JAVA_OPTS -Djava.security.egd=file:/dev/./urandom
RUN apt-get update -qq \
  && apt-get install -qqy curl wget \
  && apt-get clean \
  \
  && touch /var/log/spring-music.log \
  && chmod 666 /var/log/spring-music.log \
  \
  && mv /usr/local/tomcat/webapps/dockerjava-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war  \
  && mv /usr/local/tomcat/webapps/ROOT /usr/local/tomcat/webapps/_ROOT

COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml

# install Filebeat
ENV FILEBEAT_VERSION=filebeat_1.2.3_amd64.deb
RUN curl -L -O https://download.elastic.co/beats/filebeat/${FILEBEAT_VERSION} \
 && dpkg -i ${FILEBEAT_VERSION} \
 && rm ${FILEBEAT_VERSION}

# configure Filebeat
ADD filebeat.yml /etc/filebeat/filebeat.yml

# CA cert
RUN mkdir -p /etc/pki/tls/certs
ADD logstash-beats.crt /etc/pki/tls/certs/logstash-beats.crt

# start Filebeat
ADD ./start.sh /usr/local/bin/start.sh
RUN chmod +x /usr/local/bin/start.sh
CMD [ "/usr/local/bin/start.sh" ]
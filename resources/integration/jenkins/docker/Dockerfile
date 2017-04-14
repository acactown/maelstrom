FROM jenkins:2.46.1
MAINTAINER Ezequiel Fariña <ezefarina@gmail.com>

# TODO: Gotta take this `root` out
USER root

COPY var/ /var
RUN /usr/local/bin/install-plugins.sh $(cat ${JENKINS_HOME}/plugins.txt | tr '\n' ' ')

RUN chown -R jenkins.jenkins /usr/share/jenkins/ref
RUN chown -R jenkins.jenkins ${JENKINS_HOME}

ENV JENKINS_USER admin
ENV JENKINS_PASS admin
ENV JENKINS_OPTS --httpPort=8080
ENV BUILD local

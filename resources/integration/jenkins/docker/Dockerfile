FROM jenkins:2.46.1
MAINTAINER Ezequiel Fariña <ezefarina@gmail.com>

# TODO: Gotta take this `root` out
USER root

COPY jenkins_home/ ${JENKINS_HOME}
COPY plugins2.txt /plugins.txt
RUN /usr/local/bin/install-plugins.sh $(cat /plugins.txt | tr '\n' ' ')

RUN chown -R jenkins.jenkins /usr/share/jenkins/ref
RUN chown -R jenkins.jenkins ${JENKINS_HOME}

ENV JENKINS_USER admin
ENV JENKINS_PASS admin
ENV JENKINS_OPTS --httpPort=8080
ENV BUILD local

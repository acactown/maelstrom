package com.mulesoft.maelstrom.pipeline.agent

enum CommonAgents {

    MAVEN ("builder/maven","1.0".split()),
    NPM("builder/npm","1.0".split()),
    SBT("builder/sbt","1.0".split())

    String imageName
    String[] imageVersions

    private CommonAgents (String imageName, String[] imageVersions) {
        this.imageName=imageName
        this.imageVersions=imageVersions
    }

    String getImage

}

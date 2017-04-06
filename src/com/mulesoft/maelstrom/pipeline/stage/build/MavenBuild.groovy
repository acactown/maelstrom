package com.mulesoft.maelstrom.pipeline.stage.build

import com.mulesoft.maelstrom.pipeline.stage.Stage

class MavenBuild extends BuildStage {

    MavenBuild(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {

    }

    @Override
    String name() {
        return "MAVEN_BUILD"
    }

}

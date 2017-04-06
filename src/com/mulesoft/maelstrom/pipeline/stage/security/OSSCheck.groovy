package com.mulesoft.maelstrom.pipeline.stage.security

import com.mulesoft.maelstrom.pipeline.stage.Stage

class OSSCheck extends SecurityStage {

    OSSCheck(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {
        println("Running "+name()+" stage")
        next()

    }

    @Override
    String name() {
        return "OSS_CHECK"
    }

}

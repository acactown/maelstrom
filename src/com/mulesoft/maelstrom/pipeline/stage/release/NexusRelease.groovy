package com.mulesoft.maelstrom.pipeline.stage.release

import com.mulesoft.maelstrom.pipeline.stage.Stage

class NexusRelease extends ReleaseStage {

    NexusRelease(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {
        println("Running "+name()+" stage")
        next()

    }

    @Override
    String name() {
        return "NEXUS_RELEASE"
    }

}

package com.mulesoft.maelstrom.pipeline.stage.release

import com.mulesoft.maelstrom.pipeline.stage.Stage
import com.mulesoft.maelstrom.pipeline.stage.setup.SetupStage

class NexusRelease extends ReleaseStage {

    NexusRelease(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {

    }

    @Override
    String name() {
        return "NEXUS_RELEASE"
    }

}

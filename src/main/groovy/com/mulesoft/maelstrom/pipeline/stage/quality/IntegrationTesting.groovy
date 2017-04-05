package com.mulesoft.maelstrom.pipeline.stage.quality

import com.mulesoft.maelstrom.pipeline.stage.Stage
import com.mulesoft.maelstrom.pipeline.stage.setup.SetupStage

class IntegrationTesting extends QualityStage {

    IntegrationTesting(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {
        println("Running "+name()+" stage")
        next()

    }

    @Override
    String name() {
        return "INTEGRATION_TESTING"
    }

}

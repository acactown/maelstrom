package com.mulesoft.maelstrom.pipeline.stage.deployment

import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class DeploymentStage extends Stage {

    DeploymentStage(Stage nextInChain) {
        super(nextInChain)
    }

}

package com.mulesoft.maelstrom.pipeline.stage.provisioning

import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class ProvisioningStage extends Stage {

    ProvisioningStage(Stage nextInChain) {
        super(nextInChain)
    }

}

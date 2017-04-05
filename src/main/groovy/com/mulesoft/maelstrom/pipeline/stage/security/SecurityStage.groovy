package com.mulesoft.maelstrom.pipeline.stage.security

import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class SecurityStage extends Stage {

    SecurityStage(Stage nextInChain) {
        super(nextInChain)
    }

}

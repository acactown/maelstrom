package com.mulesoft.maelstrom.pipeline.stage.security

import com.mulesoft.maelstrom.pipeline.stage.Stage
import com.mulesoft.maelstrom.pipeline.stage.setup.SetupStage

class OSSCheck extends SecurityStage {

    OSSCheck(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {

    }

    @Override
    String name() {
        return "OSS_CHECK"
    }

}
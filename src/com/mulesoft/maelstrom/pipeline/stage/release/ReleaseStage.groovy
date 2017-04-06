package com.mulesoft.maelstrom.pipeline.stage.release

import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class ReleaseStage extends Stage {

    ReleaseStage(Stage nextInChain) {
        super(nextInChain)
    }

}

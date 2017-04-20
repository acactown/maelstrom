package com.mulesoft.maelstrom.pipeline.stage.setup

import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class SetupStage extends Stage {

  SetupStage(Stage nextInChain) {
    super(nextInChain)
  }

}

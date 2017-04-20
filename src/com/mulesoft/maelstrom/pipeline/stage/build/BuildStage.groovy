package com.mulesoft.maelstrom.pipeline.stage.build

import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class BuildStage extends Stage {

  BuildStage(Stage nextInChain) {
    super(nextInChain)
  }

}

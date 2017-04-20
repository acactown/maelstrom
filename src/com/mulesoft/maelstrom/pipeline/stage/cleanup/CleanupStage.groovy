package com.mulesoft.maelstrom.pipeline.stage.cleanup

import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class CleanupStage extends Stage {

  CleanupStage(Stage nextInChain) {
    super(nextInChain)
  }

}

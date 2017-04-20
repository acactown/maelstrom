package com.mulesoft.maelstrom.pipeline.stage.quality

import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class QualityStage extends Stage {

  QualityStage(Stage nextInChain) {
    super(nextInChain)
  }

}

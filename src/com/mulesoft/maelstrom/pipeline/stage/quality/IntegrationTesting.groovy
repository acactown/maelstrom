package com.mulesoft.maelstrom.pipeline.stage.quality

import com.mulesoft.maelstrom.pipeline.stage.Stage

class IntegrationTesting extends QualityStage {

  IntegrationTesting(Stage nextInChain) {
    super(nextInChain)
  }

  @Override
  String name() {
    return "INTEGRATION_TESTING"
  }

}

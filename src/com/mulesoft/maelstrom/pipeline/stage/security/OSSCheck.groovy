package com.mulesoft.maelstrom.pipeline.stage.security

import com.mulesoft.maelstrom.pipeline.stage.Stage

class OSSCheck extends SecurityStage {

  OSSCheck(Stage nextInChain) {
    super(nextInChain)
  }

  @Override
  String name() {
    return "OSS_CHECK"
  }

}

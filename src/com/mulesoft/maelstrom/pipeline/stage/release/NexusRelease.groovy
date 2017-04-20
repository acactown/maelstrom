package com.mulesoft.maelstrom.pipeline.stage.release

import com.mulesoft.maelstrom.pipeline.stage.Stage

class NexusRelease extends ReleaseStage {

  NexusRelease(Stage nextInChain) {
    super(nextInChain)
  }

  @Override
  String name() {
    return "NEXUS_RELEASE"
  }

}

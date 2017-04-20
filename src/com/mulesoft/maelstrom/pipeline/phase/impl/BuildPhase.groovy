package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase

class BuildPhase extends Phase {

  BuildPhase(Phase nextInChain) {
    super(nextInChain)
  }

  @Override
  Phase.Type phaseType() {
    return Phase.Type.BUILD
  }

  @Override
  String name() {
    return Phase.Type.BUILD.name()
  }

}

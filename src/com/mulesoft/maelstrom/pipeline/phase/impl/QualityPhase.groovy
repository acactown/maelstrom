package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase

class QualityPhase extends Phase {

  QualityPhase(Phase nextInChain) {
    super(nextInChain)
  }

  @Override
  Phase.Type phaseType() {
    return Phase.Type.QUALITY
  }

  @Override
  String name() {
    return Phase.Type.QUALITY.name()
  }

}

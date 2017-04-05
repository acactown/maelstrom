package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.PhaseType

class QualityPhase extends Phase {

    QualityPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    PhaseType phaseType() {
        return PhaseType.QUALITY
    }

    @Override
    String name() {
        return PhaseType.QUALITY.name()
    }

}

package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.PhaseType

class ReleasePhase extends Phase {

    ReleasePhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    PhaseType phaseType() {
        return PhaseType.RELEASE
    }

    @Override
    String name() {
        return PhaseType.RELEASE.name()
    }

}

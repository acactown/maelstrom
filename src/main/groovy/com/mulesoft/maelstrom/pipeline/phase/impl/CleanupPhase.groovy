package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.PhaseType

class CleanupPhase extends Phase {

    CleanupPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    PhaseType phaseType() {
        return PhaseType.CLEANUP
    }

    @Override
    String name() {
        return PhaseType.CLEANUP.name()
    }

}

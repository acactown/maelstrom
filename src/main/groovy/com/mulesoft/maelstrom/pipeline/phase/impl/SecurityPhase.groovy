package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.PhaseType

class SecurityPhase extends Phase {

    SecurityPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    PhaseType phaseType() {
        return PhaseType.SECURITY
    }

    @Override
    String name() {
        return PhaseType.SECURITY.name()
    }

}

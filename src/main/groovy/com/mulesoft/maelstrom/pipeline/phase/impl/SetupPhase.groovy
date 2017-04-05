package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.PhaseType

class SetupPhase extends Phase {

    SetupPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {

    }

    @Override
    PhaseType phaseType() {
        return PhaseType.SETUP
    }

    @Override
    String name() {
        return PhaseType.SETUP.name()
    }

}

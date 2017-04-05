package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.PhaseType

class BuildPhase extends Phase {

    BuildPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {

    }

    @Override
    PhaseType phaseType() {
        return PhaseType.BUILD
    }

    @Override
    String name() {
        return PhaseType.BUILD.name()
    }

}

package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase

class CleanupPhase extends Phase {

    CleanupPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    Phase.Type phaseType() {
        return Phase.Type.CLEANUP
    }

    @Override
    String name() {
        return Phase.Type.CLEANUP.name()
    }

}

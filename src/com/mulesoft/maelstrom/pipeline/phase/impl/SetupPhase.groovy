package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase

class SetupPhase extends Phase {

    SetupPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    Phase.Type phaseType() {
        return Phase.Type.SETUP
    }

    @Override
    String name() {
        return Phase.Type.SETUP.name()
    }

}

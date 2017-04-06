package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase

class SecurityPhase extends Phase {

    SecurityPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    Phase.Type phaseType() {
        return Phase.Type.SECURITY
    }

    @Override
    String name() {
        return Phase.Type.SECURITY.name()
    }

}

package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase

class ReleasePhase extends Phase {

    ReleasePhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    Phase.Type phaseType() {
        return Phase.Type.RELEASE
    }

    @Override
    String name() {
        return Phase.Type.RELEASE.name()
    }

}

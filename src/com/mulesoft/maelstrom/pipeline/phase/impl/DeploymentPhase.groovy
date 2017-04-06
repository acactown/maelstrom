package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase

class DeploymentPhase extends Phase {

    DeploymentPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    Phase.Type phaseType() {
        return Phase.Type.DEPLOYMENT
    }

    @Override
    String name() {
        return Phase.Type.DEPLOYMENT.name()
    }

}

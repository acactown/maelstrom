package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.PhaseType

class DeploymentPhase extends Phase {

    DeploymentPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    PhaseType phaseType() {
        return PhaseType.DEPLOYMENT
    }

    @Override
    String name() {
        return PhaseType.DEPLOYMENT.name()
    }

}

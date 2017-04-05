package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.PhaseType

class ProvisioningPhase extends Phase {

    ProvisioningPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    PhaseType phaseType() {
        return PhaseType.PROVISIONING
    }

    @Override
    String name() {
        return PhaseType.PROVISIONING.name()
    }

}

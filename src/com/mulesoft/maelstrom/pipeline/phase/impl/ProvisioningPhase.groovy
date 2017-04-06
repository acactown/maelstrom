package com.mulesoft.maelstrom.pipeline.phase.impl

import com.mulesoft.maelstrom.pipeline.phase.Phase

class ProvisioningPhase extends Phase {

    ProvisioningPhase(Phase nextInChain) {
        super(nextInChain)
    }

    @Override
    Phase.Type phaseType() {
        return Phase.Type.PROVISIONING
    }

    @Override
    String name() {
        return Phase.Type.PROVISIONING.name()
    }

}

package com.mulesoft.maelstrom.pipeline.stage

import com.mulesoft.maelstrom.pipeline.Step
import com.mulesoft.maelstrom.pipeline.integration.IntegrationHolder

abstract class Stage extends Step {

    Stage (Stage nextInChain) {
        super(nextInChain)
    }

    Stage () {
    }

    @Override
    void run() {
        IntegrationHolder.get().stageInit(name()+' PHASE')
        println("Running " + name() + " phase")
        next()
    }

    protected void signCompletion () {

    }

}

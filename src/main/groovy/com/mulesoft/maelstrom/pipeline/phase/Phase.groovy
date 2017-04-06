package com.mulesoft.maelstrom.pipeline.phase

import com.mulesoft.maelstrom.pipeline.Step
import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class Phase extends Step {

    Stage chainedStages

    Phase (Phase nextInChain) {
        super(nextInChain)
    }

    Phase () {
    }

    @Override
    void run() {
        println("Running "+name()+" phase")
        chainedStages.run()
        next()
    }

    abstract PhaseType phaseType()

}

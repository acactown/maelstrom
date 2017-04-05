package com.mulesoft.maelstrom.pipeline.phase

import com.mulesoft.maelstrom.pipeline.Step
import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class Phase extends Step {

    Stage chainedStages
    Phase nextInChain

    Phase (Phase nextInChain) {
        this.nextInChain=nextInChain
    }

    Phase () {
    }

    public void setNextInChain (Stage nextInChain) {
        if (this.nextInChain)
            throw new Exception ("Cannot change the next chain when it was already set")
        this.nextInChain=nextInChain
    }

    abstract PhaseType phaseType()

    protected void next() {
        if (nextInChain!=null)
            nextInChain.run()
    }

    protected void signCompletion () {

    }

}

package com.mulesoft.maelstrom.pipeline.stage

import com.mulesoft.maelstrom.pipeline.Step


abstract class Stage extends Step {

    Stage nextInChain

    Stage (Stage nextInChain) {
        this.nextInChain=nextInChain
    }

    Stage () {
    }

    void setNextInChain (Stage nextInChain) {
        this.nextInChain=nextInChain
    }

    protected void next() {
        if (nextInChain!=null)
            nextInChain.run()
    }

    protected void signCompletion () {

    }

}

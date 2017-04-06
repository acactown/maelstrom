package com.mulesoft.maelstrom.pipeline.stage

import com.mulesoft.maelstrom.pipeline.Step

abstract class Stage extends Step {

    Stage (Stage nextInChain) {
        super(nextInChain)
    }

    Stage () {
    }

    protected void signCompletion () {

    }

}

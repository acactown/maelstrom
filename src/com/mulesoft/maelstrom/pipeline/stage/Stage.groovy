package com.mulesoft.maelstrom.pipeline.stage

import com.mulesoft.maelstrom.pipeline.Step
import com.mulesoft.maelstrom.pipeline.integration.JenkinsPipeline

abstract class Stage extends Step {

    Stage (Stage nextInChain) {
        super(nextInChain)
    }

    Stage () {
    }

    @Override
    void run() {
        JenkinsPipeline.getPipeline().getScript().stage (name()+' PHASE')
        println("Running " + name() + " phase")
        next()
    }

    protected void signCompletion () {

    }

}

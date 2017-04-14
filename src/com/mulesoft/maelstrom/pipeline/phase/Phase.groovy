package com.mulesoft.maelstrom.pipeline.phase

import com.mulesoft.maelstrom.pipeline.Step
import com.mulesoft.maelstrom.pipeline.integration.JenkinsPipeline
import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class Phase extends Step {

    enum Type {
        SETUP,BUILD,QUALITY,SECURITY,RELEASE,PROVISIONING,DEPLOYMENT,CLEANUP,CUSTOM
    }

    Stage chainedStages

    Phase (Phase nextInChain) {
        super(nextInChain)
    }

    Phase () {
    }

    @Override
    void run() {
        JenkinsPipeline.getPipeline().getScript().stage (name()+' STAGE')
        println("Running " + name() + " phase")
        chainedStages.run()
        next()
    }

    abstract Type phaseType()

}

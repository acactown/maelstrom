package com.mulesoft.maelstrom.pipeline.phase

import com.mulesoft.maelstrom.pipeline.Step
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
        script.echo "aallalalalalalalalalalal"
        script.stage name()+' phase'
        println("Running " + name() + " phase")
        chainedStages.run()
        next()
    }

    abstract Type phaseType()

}

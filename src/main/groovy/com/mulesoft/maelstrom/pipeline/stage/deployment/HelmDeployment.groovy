package com.mulesoft.maelstrom.pipeline.stage.deployment

import com.mulesoft.maelstrom.pipeline.stage.Stage
import com.mulesoft.maelstrom.pipeline.stage.setup.SetupStage

class HelmDeployment extends DeploymentStage {

    HelmDeployment(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {
        println("Running "+name()+" stage")
        next()

    }

    @Override
    String name() {
        return "HELM_DEPLOYMENT"
    }

}

package com.mulesoft.maelstrom.pipeline.stage.deployment

import com.mulesoft.maelstrom.pipeline.stage.Stage

class HelmDeployment extends DeploymentStage {

  HelmDeployment(Stage nextInChain) {
    super(nextInChain)
  }

  @Override
  String name() {
    return "HELM_DEPLOYMENT"
  }

}

package com.mulesoft.maelstrom.pipeline.stage.provisioning

import com.mulesoft.maelstrom.pipeline.stage.Stage

class KubeClusterProvisioning extends ProvisioningStage {

  KubeClusterProvisioning(Stage nextInChain) {
    super(nextInChain)
  }

  @Override
  String name() {
    return "KUBE_PROVISIONING"
  }

}

package com.mulesoft.maelstrom.pipeline.stage.provisioning

import com.mulesoft.maelstrom.pipeline.stage.Stage
import com.mulesoft.maelstrom.pipeline.stage.setup.SetupStage

class KubeClusterProvisioning extends ProvisioningStage {

    KubeClusterProvisioning(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {

    }

    @Override
    String name() {
        return "KUBE_PROVISIONING"
    }

}

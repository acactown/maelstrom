package com.mulesoft.maelstrom.pipeline.stage.setup

import com.mulesoft.maelstrom.pipeline.stage.Stage

class DockerLogin extends SetupStage {

  DockerLogin(Stage nextInChain) {
    super(nextInChain)
  }

  @Override
  String name() {
    return "DOCKER_LOGIN"
  }

}

package com.mulesoft.maelstrom.pipeline.phase

import com.mulesoft.maelstrom.pipeline.Pipeline
import com.mulesoft.maelstrom.pipeline.core.Step
import com.mulesoft.maelstrom.pipeline.stage.Stage

abstract class Phase extends Step {

  enum Type {
    SETUP, BUILD, QUALITY, SECURITY, RELEASE, PROVISIONING, DEPLOYMENT, CLEANUP, CUSTOM
  }

  Stage chainedStages

  Phase(Phase nextInChain) {
    super(nextInChain)
  }

  Phase() {
  }

  @Override
  void run() {
    // This is the future: https://issues.jenkins-ci.org/browse/JENKINS-38442

    Pipeline.getIntegration().phaseInit(name() + ' STAGE')
    println("Running " + name() + " stage")
    chainedStages.run()
    next()
  }

  abstract Type phaseType()

}

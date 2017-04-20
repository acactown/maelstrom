package com.mulesoft.maelstrom.pipeline.stage

import com.mulesoft.maelstrom.pipeline.Pipeline
import com.mulesoft.maelstrom.pipeline.core.Step

abstract class Stage extends Step {

  Stage(Stage nextInChain) {
    super(nextInChain)
  }

  Stage() {
  }

  @Override
  void run() {
    Pipeline.getIntegration().stageInit(name() + ' PHASE')
    println("Running " + name() + " phase")
    next()
  }

  protected void signCompletion() {

  }

}

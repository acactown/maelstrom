package com.mulesoft.maelstrom.pipeline

abstract class Step {

  Step nextInChain

  def script

  abstract String name()

  abstract void run()

  Step(Step nextInChain) {
    this.nextInChain = nextInChain
  }

  Step() {
  }

  void setScript(def script) {
    this.@script = script
  }

  protected void signCompletion() {

  }

  protected void next() {
    if (nextInChain != null)
      nextInChain.run()
  }

}

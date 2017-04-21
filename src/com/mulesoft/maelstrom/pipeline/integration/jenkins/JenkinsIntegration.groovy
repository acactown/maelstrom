package com.mulesoft.maelstrom.pipeline.integration.jenkins

import com.mulesoft.maelstrom.pipeline.integration.Integration
import sun.reflect.generics.reflectiveObjects.NotImplementedException

class JenkinsIntegration implements Integration {

  private def script

  public def getScript() {
    return script
  }

  public JenkinsIntegration(def script) {
    this.script = script
  }

  @Override
  String getWorkingDirectory() {
    script.env.WORKINGDIRECTORY
  }

  @Override
  def stageInit(final String name) {
    script.stage name
  }

  @Override
  def stageFinish(final String name) {
    throw new NotImplementedException()
  }

  @Override
  def phaseInit(final String name) {
    script.stage name
  }

  @Override
  def phaseFinish(final String name) {
    throw new NotImplementedException()
  }

}

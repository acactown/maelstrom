package com.mulesoft.maelstrom.pipeline.integration

interface Integration {

  def stageInit(String name)

  def stageFinish(String name)

  def phaseInit(String name)

  def phaseFinish(String name)

}

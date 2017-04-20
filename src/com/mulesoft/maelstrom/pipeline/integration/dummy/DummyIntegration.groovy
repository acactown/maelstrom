package com.mulesoft.maelstrom.pipeline.integration.dummy

import com.mulesoft.maelstrom.pipeline.integration.Integration

class DummyIntegration implements Integration {

  @Override
  def stageInit(final String name) {
    // Do nothing
  }

  @Override
  def stageFinish(final String name) {
    // Do nothing
  }

  @Override
  def phaseInit(final String name) {
    // Do nothing
  }

  @Override
  def phaseFinish(final String name) {
    // Do nothing
  }

}

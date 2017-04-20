package com.mulesoft.maelstrom.pipeline.integration.detached

import com.mulesoft.maelstrom.pipeline.integration.Integration
import sun.reflect.generics.reflectiveObjects.NotImplementedException

class DetachedIntegration implements Integration {

    @Override
    def stageInit(final String name) {
      throw new NotImplementedException()
    }

    @Override
    def stageFinish(final String name) {
      throw new NotImplementedException()
    }

    @Override
    def phaseInit(final String name) {
      throw new NotImplementedException()
    }

    @Override
    def phaseFinish(final String name) {
      throw new NotImplementedException()
    }

    @Override
    def run() {
      throw new NotImplementedException()
    }

}

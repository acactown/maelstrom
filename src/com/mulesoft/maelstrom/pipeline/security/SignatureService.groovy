package com.mulesoft.maelstrom.pipeline.security

import com.mulesoft.maelstrom.pipeline.phase.Phase
import groovy.transform.PackageScope

@PackageScope
class SignatureService {

  void signPhase(Phase.Type type) {
    println("Phase signed: " + type)
  }

}

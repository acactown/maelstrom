package com.mulesoft.maelstrom.pipeline

import com.mulesoft.maelstrom.pipeline.phase.PhaseType
import groovy.transform.PackageScope

@PackageScope
class SignatureService {

    void signPhase (PhaseType type) {
        println("Phase signed: "+type)
    }

}

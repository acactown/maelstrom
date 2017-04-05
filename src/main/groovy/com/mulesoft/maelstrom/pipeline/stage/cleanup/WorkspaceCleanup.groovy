package com.mulesoft.maelstrom.pipeline.stage.cleanup

import com.mulesoft.maelstrom.pipeline.stage.Stage

class WorkspaceCleanup extends CleanupStage {

    WorkspaceCleanup(Stage nextInChain) {
        super(nextInChain)
    }

    @Override
    void run() {

    }

    @Override
    String name() {
        return "WORKSPACE_CLEANUP"
    }

}

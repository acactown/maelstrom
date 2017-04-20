package com.mulesoft.maelstrom.pipeline

import com.mulesoft.maelstrom.pipeline.integration.Integration

class Pipeline {

    private static Integration integration

    public static doIntegration (Integration integration) {
        this.integration = integration
    }

    public static Integration getIntegration() {
        if (integration==null)
            throw new NotActiveException()
        return integration
    }

    public static run () {
        if (integration==null)
            throw new NotActiveException()
        return integration.run()
    }

}

package com.mulesoft.maelstrom.pipeline.integration

import com.mulesoft.maelstrom.pipeline.PipelineComposer
import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.phase.impl.BuildPhase
import com.mulesoft.maelstrom.pipeline.phase.impl.DeploymentPhase
import com.mulesoft.maelstrom.pipeline.phase.impl.ProvisioningPhase
import com.mulesoft.maelstrom.pipeline.phase.impl.QualityPhase
import com.mulesoft.maelstrom.pipeline.phase.impl.ReleasePhase
import com.mulesoft.maelstrom.pipeline.phase.impl.SecurityPhase
import com.mulesoft.maelstrom.pipeline.phase.impl.SetupPhase
import com.mulesoft.maelstrom.pipeline.stage.build.MavenBuild
import com.mulesoft.maelstrom.pipeline.stage.deployment.HelmDeployment
import com.mulesoft.maelstrom.pipeline.stage.provisioning.KubeClusterProvisioning
import com.mulesoft.maelstrom.pipeline.stage.quality.IntegrationTesting
import com.mulesoft.maelstrom.pipeline.stage.release.NexusRelease
import com.mulesoft.maelstrom.pipeline.stage.security.OSSCheck
import com.mulesoft.maelstrom.pipeline.stage.setup.DockerLogin

class JenkinsPipeline {

    def script
    private static JenkinsPipeline inner

    public static JenkinsPipeline constructPipeline(def script) {
        inner = new JenkinsPipeline(script)
        return inner
    }

    public static JenkinsPipeline getPipeline() {
        return inner
    }

    public def getScript () {
        return script
    }

    private JenkinsPipeline(def script) {
        this.script = script
    }

    public def run () {
        Phase phase = new PipelineComposer()
            .addPhase(new SetupPhase())
            .addStage(new DockerLogin())
            .addPhase(new BuildPhase())
            .addStage(new MavenBuild())
            .addPhase(new QualityPhase())
            .addStage(new IntegrationTesting())
            .addPhase(new SecurityPhase())
            .addStage(new OSSCheck())
            .addPhase(new ReleasePhase())
            .addStage(new NexusRelease())
            .addPhase(new ProvisioningPhase())
            .addStage(new KubeClusterProvisioning())
            .addPhase(new DeploymentPhase())
            .addStage(new HelmDeployment())
            .build()
        phase.run()
    }

}

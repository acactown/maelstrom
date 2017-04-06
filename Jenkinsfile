@Library('Maelstrom')
import com.mulesoft.maelstrom.pipeline.*
import com.mulesoft.maelstrom.pipeline.phase.*
import com.mulesoft.maelstrom.pipeline.phase.impl.*
import com.mulesoft.maelstrom.pipeline.stage.*
import com.mulesoft.maelstrom.pipeline.stage.setup.*
import com.mulesoft.maelstrom.pipeline.stage.build.*
import com.mulesoft.maelstrom.pipeline.stage.quality.*
import com.mulesoft.maelstrom.pipeline.stage.security.*
import com.mulesoft.maelstrom.pipeline.stage.release.*
import com.mulesoft.maelstrom.pipeline.stage.provisioning.*
import com.mulesoft.maelstrom.pipeline.stage.deployment.*
import com.mulesoft.maelstrom.pipeline.stage.cleanup.*

node() {
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

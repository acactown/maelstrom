package com.mulesoft.maelstrom.pipeline

import com.mulesoft.maelstrom.dsl.Project
import com.mulesoft.maelstrom.dsl.parser.MaelstromDeclarationParser
import com.mulesoft.maelstrom.pipeline.core.PipelineComposer
import com.mulesoft.maelstrom.pipeline.integration.Integration
import com.mulesoft.maelstrom.pipeline.integration.jenkins.JenkinsIntegration
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

class Pipeline {

  private static Integration integration
  private static String workspace

  public static doIntegration(Integration integration) {
    this.integration = integration
  }

  public static setWorkspace(String workspace) {
    this.workspace = workspace
  }

  public static Integration getIntegration() {
    if (integration == null)
      throw new NotActiveException()
    return integration
  }

  public static void run() {

    Project p = MaelstromDeclarationParser.fromYAMLFile((Pipeline.integration.getWorkingDirectory())+"/maelstrom.yaml")

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

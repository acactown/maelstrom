package com.mulesoft.maelstrom.pipeline

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

class Test {

    static void main (String[] args) {

        def phases = new ChainComposer()

        SetupPhase setupPhase = new SetupPhase()
        def composer = new ChainComposer();
        composer.addElement(new DockerLogin())
        setupPhase.chainedStages = composer.getChainedStages()
        phases.addElement(setupPhase)

        BuildPhase buildPhase = new BuildPhase()
        new ChainComposer();
        composer.addElement(new MavenBuild())
        buildPhase.chainedStages = composer.getChainedStages()
        phases.addElement(buildPhase)

        QualityPhase qualityPhase = new QualityPhase()
        new ChainComposer();
        composer.addElement(new IntegrationTesting())
        qualityPhase.chainedStages = composer.getChainedStages()
        phases.addElement(qualityPhase)

        SecurityPhase securityPhase = new SecurityPhase()
        new ChainComposer();
        composer.addElement(new OSSCheck())
        securityPhase.chainedStages = composer.getChainedStages()
        phases.addElement(securityPhase)

        ReleasePhase releasePhase = new ReleasePhase()
        new ChainComposer();
        composer.addElement(new NexusRelease())
        releasePhase.chainedStages = composer.getChainedStages()
        phases.addElement(releasePhase)

        ProvisioningPhase provisioningPhase = new ProvisioningPhase()
        new ChainComposer();
        composer.addElement(new KubeClusterProvisioning())
        provisioningPhase.chainedStages = composer.getChainedStages()
        phases.addElement(provisioningPhase)

        DeploymentPhase deploymentPhase = new DeploymentPhase()
        new ChainComposer();
        composer.addElement(new HelmDeployment())
        deploymentPhase.chainedStages = composer.getChainedStages()
        phases.addElement(deploymentPhase)

        Phase phase = phases.getChainedPhases()

        phase.run()
    }

}

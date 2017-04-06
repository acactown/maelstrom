#!groovy

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

package com.mulesoft.maelstrom.pipeline

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.stage.Stage

class PipelineComposer {

    String currentPhaseName
    ChainComposer<Phase> phasesComposite
    Map<String, ChainComposer<Stage>> stagesComposition
    Map<String, Phase> phases

    PipelineComposer () {
    }

    PipelineComposer addPhase (Phase phase) {
        getPhasesComposer().addElement(phase)
        getPhases().put(phase.name(),phase)
        currentPhaseName=phase.name()
        return this
    }

    PipelineComposer addPhase (Phase phase, Position position, String relativeToName) {
        getPhasesComposer().addElement(phase,position,relativeToName)
        getPhases().put(phase.name(),phase)
        currentPhaseName=phase.name()
        return this
    }

    PipelineComposer addStage (Stage stage) {
        getStagesComposer(currentPhaseName).addElement(stage)
        return this
    }

    PipelineComposer addStage (Stage stage, Position position, String relativeToName) {
        getStagesComposer(currentPhaseName).addElement(stage,position,relativeToName)
        return this
    }

    Phase build() {
        ChainComposer chain
        String phaseName
        for (Map.Entry<String,Phase> entry : phases) {
            phaseName=entry.getKey()
            chain=stagesComposition.get(phaseName)
            phases.get(phaseName).chainedStages=chain.build()
        }
        return phasesComposite.build()
    }

    ChainComposer getPhasesComposer () {
        if (phasesComposite==null)
            phasesComposite = new ChainComposer<Phase>()
        return phasesComposite;
    }

    Map getPhases () {
        if (phases==null)
            phases = new HashMap<String, Phase>()
        return phases;
    }

    ChainComposer getStagesComposer (String phaseName) {
        ChainComposer stages
        if (stagesComposition==null)
            stagesComposition=new HashMap<String,ChainComposer<Stage>>()
        if (stagesComposition.containsKey(phaseName))
            stages=stagesComposition.get(phaseName)
        else {
            stages=new ChainComposer<Stage>()
            stagesComposition.put(phaseName,stages)
        }
        return stages;
    }

}

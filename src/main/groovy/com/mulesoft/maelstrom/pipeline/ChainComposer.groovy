package com.mulesoft.maelstrom.pipeline

import com.mulesoft.maelstrom.pipeline.phase.Phase
import com.mulesoft.maelstrom.pipeline.stage.Stage

class ChainComposer {

    enum Position {
        FIRST,LAST,AFTER,BEFORE
    }

    List<Step> elements
    List<String> elementsNames

    void addElement (Step element) {
        addElement(element,Position.LAST,null)
    }

    void addElement (Step element, Position position, String relativeToName) {
        if (elements==null)
            elements=new ArrayList<Phase>()
        if (elementsNames==null)
            elementsNames=new ArrayList<Phase>()

        if (exists(element.name()))
            throw new Exception("A phase with name {"+element.name()+"} already exists")
        if (relativeToName!=null && !exists(element.name()))
            throw new Exception("There's no phase called {"+relativeToName+"}")

        switch (position) {
            case Position.LAST:
                elements.add(element)
                elementsNames.add(element.name())
                break
            case Position.FIRST:
                elements.add(0,element)
                elementsNames.add(0,element.name())
                break
            case Position.AFTER:
                if (relativeToName==null)
                    throw new Exception ("For AFTER positioning a relativeToName has to be provided")
                int currPos = elementsNames.indexOf(relativeToName) + 1
                elements.add(currPos,element)
                elementsNames.add(currPos,element.name())
                break
            case Position.BEFORE:
                if (relativeToName==null)
                    throw new Exception ("For BEFORE positioning a relativeToName has to be provided")
                int currPos = elementsNames.indexOf(relativeToName)
                elements.add(currPos,element)
                elementsNames.add(currPos,element.name())
                break
        }
    }

    boolean exists (String name) {
        return elementsNames.indexOf(name)>-1
    }

    Stage getChainedStages () {
        Stage previous = null
        for (Stage stage : elements) {
            if (previous!=null)
                previous.setNextInChain(stage)
            previous=stage
        }
        return elements.get(0)
    }

    Phase getChainedPhases () {
        Phase previous = null
        for (Phase phase : elements) {
            if (previous!=null)
                previous.setNextInChain(phase)
            previous=phase
        }
        return elements.get(0)
    }

}

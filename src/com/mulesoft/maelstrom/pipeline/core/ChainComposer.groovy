package com.mulesoft.maelstrom.pipeline.core

import com.mulesoft.maelstrom.pipeline.phase.Phase

class ChainComposer<T extends Step> {

  List<Step> elements
  List<String> elementsNames

  ChainComposer addElement(Step element) {
    addElement(element, Position.LAST, null)
    return this
  }

  ChainComposer addElement(Step element, Position position, String relativeToName) {
    if (elements == null)
      elements = new ArrayList<Phase>()
    if (elementsNames == null)
      elementsNames = new ArrayList<Phase>()

    if (exists(element.name()))
      throw new Exception("A phase with name {" + element.name() + "} already exists")
    if (relativeToName != null && !exists(element.name()))
      throw new Exception("There's no phase called {" + relativeToName + "}")

    switch (position) {
      case Position.LAST:
        elements.add(element)
        elementsNames.add(element.name())
        break
      case Position.FIRST:
        elements.add(0, element)
        elementsNames.add(0, element.name())
        break
      case Position.AFTER:
        if (relativeToName == null)
          throw new Exception("For AFTER positioning a relativeToName has to be provided")
        int currPos = elementsNames.indexOf(relativeToName) + 1
        elements.add(currPos, element)
        elementsNames.add(currPos, element.name())
        break
      case Position.BEFORE:
        if (relativeToName == null)
          throw new Exception("For BEFORE positioning a relativeToName has to be provided")
        int currPos = elementsNames.indexOf(relativeToName)
        elements.add(currPos, element)
        elementsNames.add(currPos, element.name())
        break
    }
    return this
  }

  boolean exists(String name) {
    return elementsNames.indexOf(name) > -1
  }

  T build() {
    T previous = null
    for (T element : elements) {
      if (previous != null)
        previous.setNextInChain(element)
      previous = element
    }
    return elements.get(0)
  }

}

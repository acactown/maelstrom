package com.mulesoft.maelstrom.pipeline

abstract class Step {

    Step nextInChain

    abstract String name()
    abstract void run()

    Step (Step nextInChain) {
        this.nextInChain=nextInChain
    }

    Step () {
    }

    protected void signCompletion () {

    }

    protected void next() {
        if (nextInChain!=null)
            nextInChain.run()
    }

}

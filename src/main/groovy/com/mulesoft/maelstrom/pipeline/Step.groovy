package com.mulesoft.maelstrom.pipeline

abstract class Step {

    abstract String name()
    abstract void run()

}

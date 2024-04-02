package com.github.fabriciolfk.examples

class Facade {
}


class CPU {
    fun processData() {
        println("processing data ..")
    }
}

class Memory {
    fun load() {
        println("loading data into memory")
    }
}

class HardDriver {
    fun readData() {
        println("reading data from hard drive...")
    }
}

class ComputerFacade(private val cpu: CPU, private val memory: Memory, private val hardDriver: HardDriver) {

    fun start() {
        println("computer facade starting...")
        cpu.processData()
        memory.load()
        hardDriver.readData()
        println("computer facade successfully...")
    }
}

fun main() {
    // Create subsystem components
    val cpu = CPU()
    val memory = Memory()
    val hardDrive = HardDriver()

    // Create facade and pass subsystem components to it
    val computerFacade = ComputerFacade(cpu, memory, hardDrive)

    // Client interacts with the subsystem through the facade
    computerFacade.start()
}
package com.github.fabriciolfk.examples.pattern

/*
class Adapter {
}

interface Printer {
    fun print()
}

class ModerPrinter {
    fun startPrint() {
        println("Printing in a modern way")
    }
}

class ModerPrinterAdapter(private val moderPrinter: ModerPrinter) : Printer {
    override fun print() {
        moderPrinter.startPrint()
    }

}

fun main() {
    val moder = ModerPrinter()
    val legacy = ModerPrinterAdapter(moder)
    legacy.print()
}*/
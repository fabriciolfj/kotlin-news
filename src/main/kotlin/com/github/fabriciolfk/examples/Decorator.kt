package com.github.fabriciolfk.examples

class Decorator {
}

interface Car2 {
    fun drive()
}

class BasicCar : Car2 {
    override fun drive() {
        println("move A to B")
    }

}

fun Car2.decorate(initialize: () -> Unit) : Car2 {
    return object : Car2 {
        override fun drive() {
            initialize()
            this@decorate.drive()
        }
    }
}

fun main() {
    val car = BasicCar().decorate { println("off road car") }
    car.drive()
}
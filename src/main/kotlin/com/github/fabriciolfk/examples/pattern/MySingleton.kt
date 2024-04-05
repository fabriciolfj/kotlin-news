package com.github.fabriciolfk.examples.pattern

class MySingleton private constructor() {

    companion object {
        private val instance: MySingleton by lazy { MySingleton() }

        fun pegar(): MySingleton {
            return instance
        }
    }

    // Singleton properties and methods go here

    fun doSomething() {
        println("Singleton is doing something")
    }
}

/*
fun main() {
    val instance = MySingleton.pegar()

    instance.doSomething()
}*/
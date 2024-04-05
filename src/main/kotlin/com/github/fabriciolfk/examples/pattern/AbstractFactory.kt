package com.github.fabriciolfk.examples.pattern

class AbstractFactory {
}

interface Vehicle2 {
    fun getDescription(): String
}

class Car3 : Vehicle2 {
    override fun getDescription(): String = "I am a car"
}

class Truck2 : Vehicle2 {
    override fun getDescription(): String = "I am a truck"
}

interface VehicleFactory2 {
    fun createCar(): Vehicle2
    fun createTruck(): Vehicle2
}

class ConcreteVehicleFactory : VehicleFactory2 {
    override fun createCar(): Vehicle2 = Car3()
    override fun createTruck(): Vehicle2 = Truck2()
}
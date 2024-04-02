package com.github.fabriciolfk.examples

class FactoryMethod {
}

interface Vehicle {
    fun getDescription(): String
}

class Car : Vehicle {
    override fun getDescription(): String = "I am a car"
}

class Truck : Vehicle {
    override fun getDescription(): String = "I am a truck"
}

abstract class VehicleFactory {
    abstract fun createVehicle(): Vehicle

    fun produceVehicle(): Vehicle {
        val vehicle = createVehicle()
        // Outras operações com o veículo
        return vehicle
    }
}

class CarFactory : VehicleFactory() {
    override fun createVehicle(): Vehicle = Car()
}

class TruckFactory : VehicleFactory() {
    override fun createVehicle(): Vehicle = Truck()
}
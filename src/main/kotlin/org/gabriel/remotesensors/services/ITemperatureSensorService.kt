package org.gabriel.remotesensors.services

interface ITemperatureSensorService {
    fun enqueue(temperature: Double)
    fun dequeue(): Double
}

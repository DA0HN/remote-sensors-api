package org.gabriel.remotesensors.services

/**
 * @project remote-sensors-api
 * @author daohn on 18/12/2020
 */
interface ITemperatureSensorService {
    fun enqueue(temperature: Double)
    fun dequeue(): Double
}

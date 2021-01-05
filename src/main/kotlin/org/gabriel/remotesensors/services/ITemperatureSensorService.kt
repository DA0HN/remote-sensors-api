package org.gabriel.remotesensors.services

import org.gabriel.remotesensors.models.Data

/**
 * @project remote-sensors-api
 * @author daohn on 18/12/2020
 */
interface ITemperatureSensorService {
    fun enqueue(temperature: Double)
    fun dequeue(): Data
}

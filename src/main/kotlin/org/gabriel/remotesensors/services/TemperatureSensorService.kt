package org.gabriel.remotesensors.services

import org.springframework.stereotype.Service
import java.util.*


/**
 * @project remotesensors
 * @author daohn on 18/12/2020
 */
@Service
class TemperatureSensorService : ITemperatureSensorService {

    private var queue: Queue<Double> = LinkedList()

    override fun enqueue(temperature: Double) {
        queue.add(temperature)
    }

    override fun dequeue(): Double {
        return queue.poll()
    }
}
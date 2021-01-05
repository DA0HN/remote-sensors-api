package org.gabriel.remotesensors.services

import org.gabriel.remotesensors.models.Data
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


/**
 * @project remote-sensors-api
 * @author daohn on 18/12/2020
 */
@Service
class TemperatureSensorService : ITemperatureSensorService {

    private var queue: Queue<Data> = LinkedList()

    override fun enqueue(temperature: Double) {
        queue.add(
            Data(
                temperature = temperature,
                date = LocalDateTime.now(ZoneId.of("GMT-4"))
            )
        )
    }

    override fun dequeue(): Data {
        return queue.poll()
    }
}
package org.gabriel.remotesensors.services

import mu.KotlinLogging
import org.gabriel.remotesensors.models.Data
import org.gabriel.remotesensors.models.DataResponse
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

    private val logger = KotlinLogging.logger {}
    private val maxSize = 50
    private var queue: Queue<Data> = LinkedList()

    override fun enqueue(temperature: Double): DataResponse {
        val data = Data(
            temperature = temperature,
            date = LocalDateTime.now(ZoneId.of("GMT-4"))
        )

        if (queue.size >= maxSize) {
            logger.warn{ "Não é possível adicionar mais de $maxSize valores" }
            return DataResponse(
                queueSize = queue.size,
                message = "Não é possível adicionar mais de $maxSize valores",
                hasError = true,
            )
        }

        queue.add(data)

        logger.info { "Temperatura adicionada à fila $data" }

        return DataResponse(
            data = data,
            queueSize = queue.size,
            message = "Temperatura adicionada à fila",
        )

    }

    override fun dequeue(): DataResponse {
        if (queue.size == 0) {
            logger.warn { "Não há elementos adicionados à fila" }

            return DataResponse(
                queueSize = queue.size,
                message = "Não há elementos adicionados à fila",
                hasError = true,
            )
        }

        val data = queue.poll()

        logger.info { "$data retirado da fila" }

        return DataResponse(
            data = data,
            queueSize = queue.size,
        )
    }
}
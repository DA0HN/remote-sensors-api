package org.gabriel.remotesensors.controllers

import org.gabriel.remotesensors.models.DataResponse
import org.gabriel.remotesensors.services.ITemperatureSensorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * @project remote-sensors-api
 * @author daohn on 18/12/2020
 */
@RestController
@RequestMapping("/temperature")
class TemperatureSensorController(private val temperatureSensorService: ITemperatureSensorService) {

    @PostMapping
    fun enqueue(@RequestBody temperature: Double): ResponseEntity<DataResponse> {
        val response = temperatureSensorService.enqueue(temperature)

        if (response.hasError)
            return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(response)

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping
    fun dequeue(): ResponseEntity<DataResponse> {
        val response = temperatureSensorService.dequeue()

        if (response.hasError)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)

        return ResponseEntity.ok(response)
    }
}
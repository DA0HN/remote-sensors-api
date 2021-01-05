package org.gabriel.remotesensors.controllers

import org.gabriel.remotesensors.models.Data
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
    fun enqueue(@RequestBody temperature: Double): ResponseEntity<String> {
        temperatureSensorService.enqueue(temperature)
        return ResponseEntity.status(HttpStatus.CREATED).body("Temperatura adicionada na fila")
    }

    @GetMapping
    fun dequeue(): ResponseEntity<Data> {
        val temp = temperatureSensorService.dequeue()
        return ResponseEntity.ok(temp)
    }
}
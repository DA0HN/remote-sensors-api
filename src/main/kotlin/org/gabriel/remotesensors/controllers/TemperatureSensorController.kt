package org.gabriel.remotesensors.controllers

import org.gabriel.remotesensors.services.ITemperatureSensorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * @project remotesensors
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
    fun dequeue(): ResponseEntity<Double> {
        val temp = temperatureSensorService.dequeue()
        return ResponseEntity.ok(temp)
    }
}
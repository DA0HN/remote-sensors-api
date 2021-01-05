package org.gabriel.remotesensors.models

import java.time.LocalDateTime

/**
 * @project remote-sensors-api
 * @author daohn on 05/01/2021
 */
data class Data(
    val temperature: Double,
    val date: LocalDateTime,
)

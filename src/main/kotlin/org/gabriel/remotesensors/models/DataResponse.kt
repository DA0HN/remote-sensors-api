package org.gabriel.remotesensors.models

data class DataResponse(
    val data: Data? = null,
    val queueSize: Int,
    val message: String? = null,
    val hasError: Boolean = false,
)

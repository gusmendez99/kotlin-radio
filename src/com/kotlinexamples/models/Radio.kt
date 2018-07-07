package com.kotlinexamples.models

class Radio (
        private val brand: String,
        private var isTurnedOn: Boolean = false,
        private var isOnFM: Boolean = false,
        private var volume: Int = 0,
        private var station: Double = 87.0
) {
    fun turnOn(){
        isTurnedOn = true
    }

    fun turnOff(){
        isTurnedOn = false
    }

    override fun toString(): String {
        return """
            Radio:
                Brand: $brand
                Frequency: ${if(isOnFM) return "FM" else "AM"}
                Volume: $volume
                Station: $station
                Is Turned On: $isTurnedOn
        """.trimIndent()
    }

}
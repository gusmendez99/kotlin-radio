package com.kotlinexamples.models

class Radio (
        val brand: String,
        var isTurnedOn: Boolean = false,
        var isOnFM: Boolean = false,
        var volume: Int = 0,
        var station: Double = 87.0
) {

    fun turnOn(){
        isTurnedOn = true
    }

    fun turnOff(){
        isTurnedOn = false
    }

    fun changeFrequency() { isOnFM = !isOnFM }

    fun changeVolumeLevel(isVolumeUp: Boolean, level:Int) {
        if(isVolumeUp) { volume += level } else { volume -= level }
    }

    override fun toString(): String {
        return """
            Radio:
                Marca: $brand
                Frecuencia: ${if(isOnFM) "FM" else "AM"}
                Volumen: $volume
                Estacion: $station
                Encendida?: $isTurnedOn
        """.trimIndent()
    }

}
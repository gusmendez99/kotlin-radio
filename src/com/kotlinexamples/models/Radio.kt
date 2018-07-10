package com.kotlinexamples.models

const val MAX_FM_STATION = 107.0
const val MIN_FM_STATION = 87.0
const val MAX_AM_STATION = 1400.0
const val MIN_AM_STATION = 1000.0


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

    fun changeFrequency() {
        isOnFM = !isOnFM
        station = if(isOnFM) {
            MIN_FM_STATION
        } else {
            MIN_AM_STATION
        }

    }

    fun changeStation(isStationUp: Boolean, steps: Double){
        if(isStationUp) { station += steps } else { station -= steps }
    }

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
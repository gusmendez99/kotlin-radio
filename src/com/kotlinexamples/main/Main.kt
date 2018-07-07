package com.kotlinexamples.main

import com.kotlinexamples.models.Radio

fun main(args: Array<String>) {
    val myRadio = Radio(brand = "Pioneer", isOnFM = false, isTurnedOn = false,
            station = 87.0, volume = 0)

    println(myRadio)



}
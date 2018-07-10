package com.kotlinexamples.main

import com.kotlinexamples.models.Radio

fun main(args: Array<String>) {

    var brand: String = ""
    var okBrand = false
    do {
        print("Ingresa la marca del radio: ")
        val strBrand: String? = readLine()
        if (strBrand != null) {
            brand = strBrand
            okBrand = true
        } else {
            println("Error, ingresa una marca valida")
            //okBrand = false
        }
    } while (!okBrand)

    val myRadio = Radio(brand = brand, isOnFM = false, isTurnedOn = false,
            station = 87.0, volume = 0)

    var isOptionExit:Boolean = false
    var okOption:Boolean = false

    do {
        var selectedOption:Int = 0
        //Ciclo para elegir opcion
        println(getMenuOptions(myRadio.isTurnedOn))
        print("Ingresa tu opcion: ")
        val optionEntered: String? = readLine()
        if (optionEntered != null) {
            try {
                selectedOption = optionEntered.trim().toInt()
                okOption = true
            } catch (error: NumberFormatException) {
                println("ERROR: la opcion no es un numero, intenta de nuevo...")
            }
        }

        if (okOption) {
            if (myRadio.isTurnedOn) {
                //Menu when radio is turned on
                when (selectedOption) {
                    1 -> {
                        myRadio.turnOff()
                        println("RADIO APAGADA!\n")
                    }
                    2 -> {
                        println("Estado actual: $myRadio")
                    }
                    3 -> {
                        myRadio.changeFrequency()
                        println("Se cambio la frecuencia de ${if(myRadio.isOnFM) "AM a FM" else "FM a AM"}")
                    }
                    4 -> {
                        print("Digite 's' para subir volumen, o 'b' para bajar: ")
                        val optionVolume:String? = readLine()
                        if(optionVolume != null) {
                            if(optionVolume.toLowerCase() == "b") {
                                // Opcion para bajar volumen
                                print("Digite la cantidad de unidades a bajar: ")
                                val steps:String? = readLine()
                                var stepsCount = 0
                                if (steps != null) {
                                    try {
                                        stepsCount = steps.trim().toInt()
                                    } catch (error: NumberFormatException) {
                                        println("ERROR: la cantidad no es un numero, intenta de nuevo...")
                                    }
                                }

                                if(stepsCount > 0) {
                                    //Significa que si se ingreso un numero valido
                                    if(myRadio.volume < stepsCount) {
                                        println("ERROR: La cantidad a bajar es mayor a la actual, intenta de nuevo...")
                                    } else {
                                        myRadio.changeVolumeLevel(false, stepsCount)
                                        println("VOLUMEN REDUCIDO EN $stepsCount UNIDADES")
                                    }
                                }

                            } else if (optionVolume.toLowerCase() == "s"){
                                // Opcion para bajar volumen
                                print("Digite la cantidad de unidades a subir: ")
                                val steps:String? = readLine()
                                var stepsCount = 0
                                if (steps != null) {
                                    try {
                                        stepsCount = steps.trim().toInt()
                                    } catch (error: NumberFormatException) {
                                        println("ERROR: la cantidad no es un numero, intenta de nuevo...")
                                    }
                                }

                                if(stepsCount > 0) {
                                    //Significa que si se ingreso un numero valido
                                    if(myRadio.volume + stepsCount > 100) {
                                        println("ERROR: La cantidad a subir sobrepasa las 100 unidades, intenta de nuevo...")
                                    } else {
                                        myRadio.changeVolumeLevel(true, stepsCount)
                                        println("VOLUMEN AUMENTADO EN $stepsCount UNIDADES")
                                    }
                                }
                            } else {
                                println("Opcion invalida, intenta de nuevo...")
                            }
                        }

                    }
                    5 -> {

                    }
                    6 -> {
                        isOptionExit = true
                    }
                    else -> { // Note the block
                        println("Opcion invalida, intente de nuevo...")
                    }


                }
            } else {
                //Menu when radio is turned off
                when (selectedOption) {
                    1 -> {
                        myRadio.turnOn()
                        println("RADIO ENCENDIDA!\n")
                    }
                    2 -> {
                        isOptionExit = true
                    }
                    else -> { // Note the block
                        println("Opcion invalida, intente de nuevo...")
                    }

                }
            }
        }
    } while (!isOptionExit)

    println("Good Bye :)")
}


fun getMenuOptions(turnedOn: Boolean):String {
    if(turnedOn){
        return """
            ************************
                     MENU
            ************************
            1. Apagar radio
            2. Ver estado del radio
            3. Cambiar AM/FM
            4. Cambiar nivel de volumen
            5. Cambiar estacion
            6. Salir
        """.trimIndent()
    } else {
        return """
            ************************
                     MENU
            ************************
            1. Encender radio
            2. Salir
        """.trimIndent()
    }
}

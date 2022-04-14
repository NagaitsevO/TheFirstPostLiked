package ru.netology.nmedia

fun ToCutTheNumber (incomingNumber: Int): String {
    var numberOut: String = ""

    if (incomingNumber < 1000) {
        numberOut = ("$incomingNumber")
    }
    if ((incomingNumber >= 1000)&&(incomingNumber<10000)) {
        var figure: Double = (incomingNumber.toDouble())/1000
        numberOut = String.format("%.1f", figure)
        numberOut += " K"
    }
    if ((incomingNumber >= 10000)&&(incomingNumber<1000000)) {
        var figure: Double = (incomingNumber.toDouble())/1000
        var figureInt = figure.toInt()
        numberOut += "$figureInt K"
    }
    if (incomingNumber >= 1000000) {
        var figure: Double = (incomingNumber.toDouble())/1000000
        numberOut = String.format("%.1f", figure)
        numberOut += " M"
    }
    return numberOut
}

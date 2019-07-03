package ru.skillbranch.devintensive.extensions


import java.text.SimpleDateFormat
import java.util.*



const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateForman = SimpleDateFormat(pattern, Locale("ru"))
    return dateForman.format(this)
}

fun Date.add(value: Int, units: TimeUnits): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {

    val curDate = Date()
    var result = ""
    var strQuant = ""

    val dicMin: List<Pair<String, String>> =
        listOf(
            "1" to "у",
            "2" to "ы",
            "3" to "ы",
            "4" to "ы",
            "5" to "",
            "6" to "",
            "7" to "",
            "8" to "",
            "9" to "",
            "10" to ""
        )
    val dicHour: List<Pair<String, String>> =
        listOf(
            "1" to "",
            "2" to "а",
            "3" to "а",
            "4" to "а",
            "5" to "ов",
            "6" to "ов",
            "7" to "ов",
            "8" to "ов",
            "9" to "ов",
            "10" to "ов"
        )

    val dicDay: List<Pair<String, String>> =
        listOf(
            "1" to "ь",
            "2" to "я",
            "3" to "я",
            "4" to "я",
            "5" to "ей",
            "6" to "ей",
            "7" to "ей",
            "8" to "ей",
            "9" to "ей",
            "10" to "ей"
        )

    val difDate = curDate.time - date.time
    println(difDate.toString())
    val seconds = difDate / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    fun getEnding(quant: Long, unit: TimeUnits): String {
        val dic: List<Pair<String, String>>
        val sb = StringBuilder()
        when (unit) {
            TimeUnits.DAY -> dic = dicDay
            TimeUnits.HOUR -> dic = dicHour
            TimeUnits.MINUTE -> dic = dicMin
            else -> dic = mutableListOf()
        }
        if(quant>10){
            strQuant =quant.toString().get(quant.toString().length-1).toString()
        }else{
            strQuant = quant.toString()
        }

        for (d in dic){
            if(d.first == strQuant) {

                sb.append(d.second)
            }
        }

        if(11<= quant ){
            if (quant<=20){
                sb.clear()
                sb.append(getEnding(5, unit))
            }
        }

        return sb.toString()
    }


    if (seconds != 0L) {
        result = "несколько секунд назад"
    }
    if (minutes != 0L) {
        result = "$minutes минут${getEnding(minutes, TimeUnits.MINUTE)} назад"
    }
    if (hours != 0L) {
        result = "$hours час${getEnding(hours, TimeUnits.HOUR)} назад"
    }
    if (days != 0L) {
        result = "$days дн${getEnding(days, TimeUnits.DAY)} назад"
    }
    if(difDate == 0L){
        result = "только что"
    }

    return "$result "
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}
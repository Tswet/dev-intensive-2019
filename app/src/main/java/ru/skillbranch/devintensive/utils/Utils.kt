package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder


object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        val parse: List<String>? = fullName?.split(" ")
        val firstName = parse?.getOrNull(0)
        val lastName = parse?.getOrNull(1)
        //return Pair(parse.getOrNull(0), parse.getOrNull(1))
        return firstName to lastName  //shot syntax
    }

    fun transliteration(firstName: String?, lastName: String?): String? {

        val sb= StringBuilder()
        val dic : List<Pair<String, String>> =
            listOf(
                " " to " ",
                "а" to "a",
                "б" to "b",
                "в" to "v",
                "г" to "g",
                "д" to "d",
                "е" to "e",
                "ё" to "e",
                "ж" to "zh",
                "з" to "z",
                "и" to "i",
                "й" to "i",
                "к" to "k",
                "л" to "l",
                "м" to "m",
                "н" to "n",
                "о" to "o",
                "п" to "p",
                "р" to "r",
                "с" to "s",
                "т" to "t",
                "у" to "u",
                "ф" to "f",
                "х" to "h",
                "ц" to "c",
                "ч" to "ch",
                "ш" to "sh",
                "щ" to "sh'",
                "ъ" to "",
                "ы" to "i",
                "ь" to "",
                "э" to "e",
                "ю" to "yu",
                "я" to "ya")

        val fulNane  = "$firstName $lastName"

        for(c in fulNane){
            for(d in dic){
                if(d.first.toLowerCase() == c.toString().toLowerCase())sb.append(d.second)
            }
        }
        val pair : List<String>? = sb.toString().split(" ")

        return "${pair?.get(0)?.capitalize()} ${pair?.get(1)?.capitalize()}"
    }



    fun toInitials(firstName: String?, lastName: String?): Any {

        val fnI = firstName?.get(0)?.toUpperCase()
        val lnI = lastName?.get(0)?.toUpperCase()

        return "$fnI. $lnI."
    }
}
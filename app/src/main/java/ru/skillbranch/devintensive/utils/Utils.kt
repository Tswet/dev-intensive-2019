package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder


object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        var lastName: String?
        var firstName: String?

        val parse: List<String>? = fullName?.split(" ")
        firstName = parse?.getOrNull(0)
        lastName = parse?.getOrNull(1)
        //return Pair(parse.getOrNull(0), parse.getOrNull(1))
        if (firstName?.length == 0) firstName = null
        if (lastName?.length == 0) lastName = null

        return firstName to lastName  //shot syntax
    }

    fun transliteration(firstName: String?, lastName: String?): String? {

        val sb = StringBuilder()
        val dic: List<Pair<String, String>> =
            listOf(
                "_" to "",
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
                "я" to "ya"
            )

        val fulName = "$firstName $lastName"


        for (c in fulName) {
            for (d in dic) {
                if (d.first.toLowerCase() == c.toString().toLowerCase()) sb.append(d.second)
            }
        }
        val pair: List<String>? = sb.toString().split(" ")
        sb.clear()
        if (pair != null) {
            for (p in pair){
                sb.append(p.capitalize())
                sb.append(" ")
            }
        }

        return sb.toString()
    }


    fun toInitials(firstName: String?, lastName: String?): Any {

        var fnI : String? =null
        var lnI: String? =null
        var result: StringBuilder? = StringBuilder()

        if(!firstName.isNullOrBlank()) fnI = firstName.get(0).toUpperCase().toString()
        if(!lastName.isNullOrBlank()) lnI = lastName.get(0).toUpperCase().toString()


        if (!fnI.isNullOrBlank()) result?.append(fnI)
        if (!lnI.isNullOrBlank()) result?.append(lnI)
        if(result.toString().equals(""))result = null

        return result.toString()
    }
}
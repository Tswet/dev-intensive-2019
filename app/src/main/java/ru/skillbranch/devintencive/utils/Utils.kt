package ru.skillbranch.devintencive.utils

import java.util.*

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        val parse: List<String>? = fullName?.split(" ")
        //return Pair(parse.getOrNull(0), parse.getOrNull(1))
        return parse?.getOrNull(0) to parse?.getOrNull(1)  //shot syntax
    }

    fun transLiteration(firstName: String?, lastName: String?): String? {
        return ""
    }

    fun makeInitial(firstName: String?, lastName: String?): Any {

        return ""
    }
}
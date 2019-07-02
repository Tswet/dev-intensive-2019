package ru.skillbranch.devintencive.models

import java.util.*

class User(
    private val id: String?,
    private var firstName: String?,
    private var lastName: String?,
    private var avatar: String?,
    private var rating: Int = 0,
    private var respect: Int = 0,
    private val lastVisit: Date? = null,
    private val isOnLine: Boolean = false
) {
    constructor(id: String?, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String?) : this(id, "Vasya", "Vasin")

    init {
        println("La-la-la")
    }

    fun printMe() {
        println(
            """
        id: $id
        firstName: $firstName
        lastName:$lastName
        avatar:$avatar
        rating:$rating
        respect:$respect
        lastVisit:$lastVisit
        isOnLine:$isOnLine
        """.trimIndent()
        )
    }

    companion object Factory{
        private var lastId:Int=-1

        fun makeUser(fullName:String?):User{
            lastId++
            val parts:List<String>?= fullName?.split(" ")

            return User(id = "$lastId", firstName = parts?.getOrNull(0) , lastName = parts?.getOrNull(1))
        }
    }
}
package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
     val id: String?,
     var firstName: String?,
     var lastName: String?,
     var avatar: String?,
     var rating: Int = 0,
     var respect: Int = 0,
     val lastVisit: Date? = null,
     val isOnLine: Boolean = false
) {
    constructor(id: String?, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String?) : this(id, "John", "Doe")

    init {
        println("$firstName  $lastName created")
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
            val(firstName, lastname) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName , lastName = lastname)
        }
    }

    /*companion object Builder {
        protected var id: String? = null
        protected var lastName: String? = null
        protected var firstName: String? = null
        protected var avatar: String? = null
        protected var rating: Int = 0
        protected var respect: Int = 0
        protected var lastVisit: Date? = null
        protected var isOnLine: Boolean = false

        fun id(value: String) = apply { id = value }
        fun lastName(value: String) = apply { lastName = value }
        fun firstName(value: String) = apply { firstName = value }
        fun avatar(value: String) = apply { avatar = value }
        fun rating(value: Int) = apply { rating = value }
        fun respect(value: Int) = apply { respect = value }
        fun lastVisit(value: Date) = apply { lastVisit = value }
        fun isOnLine(value: Boolean) = apply { isOnLine = value }

        fun build(): User {
            return User(id = id, firstName = firstName, lastName = lastName,
                avatar = avatar,rating = rating, respect = respect,lastVisit = lastVisit, isOnLine = isOnLine)
        }
    }*/



}
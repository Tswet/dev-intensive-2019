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
     val isOnline: Boolean = false
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
        isOnline:$isOnline
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

    class Builder {
         var id: String? = null
         var lastName: String? = null
         var firstName: String? = null
         var avatar: String? = null
         var rating: Int = 0
         var respect: Int = 0
         var lastVisit: Date? = null
         var isOnline: Boolean = false

        fun id(value: String) = apply { id = value }
        fun lastName(value: String) = apply { lastName = value }
        fun firstName(value: String) = apply { firstName = value }
        fun avatar(value: String) = apply { avatar = value }
        fun rating(value: Int) = apply { rating = value }
        fun respect(value: Int) = apply { respect = value }
        fun lastVisit(value: Date) = apply { lastVisit = value }
        fun isOnLine(value: Boolean) = apply { isOnline = value }

        fun build(): User {
            return User(id = id, firstName = firstName, lastName = lastName,
                avatar = avatar,rating = rating, respect = respect,lastVisit = lastVisit, isOnline = isOnline)
        }
    }
}
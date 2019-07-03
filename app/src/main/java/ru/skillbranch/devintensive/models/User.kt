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

   /* companion object Builder {
        protected var id: String? = null
        protected var name: String? = null
        protected var firstName: String? = null

        fun id(value: String) = apply { id = value }
        fun name(value: String) = apply { name = value }
        fun firstName(value: String) = apply { firstName = value }

        fun build(): User {
            return User(id = id)
        }
    }*/

    fun toUserView(){}

}
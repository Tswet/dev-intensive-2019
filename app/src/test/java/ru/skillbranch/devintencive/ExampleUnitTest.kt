package ru.skillbranch.devintencive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintencive.models.User

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_inst(){
        val user = User("1")
        val user1 = User("2", "Petay","petrov")
        val user2 = User("3")

        user.printMe()
        user1.printMe()
        user2.printMe()

        println("$user, $user1, $user2")
    }

    @Test
    fun test_factory(){
        User.makeUser("Vasya Ivanov")
    }
}

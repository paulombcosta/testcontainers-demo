package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserRepositoryTest : DatabaseTest() {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun `test can insert user`() {
        val user = User(1, "Paulo", "Costa")
        userRepository.save(user)
        assertEquals(user, userRepository.findById(1).get())
    }

}
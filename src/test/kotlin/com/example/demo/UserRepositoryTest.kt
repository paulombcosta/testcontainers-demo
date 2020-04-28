package com.example.demo

import org.springframework.beans.factory.annotation.Autowired

class UserRepositoryTest() : DatabaseTest() {

    @Autowired
    lateinit var userRepository: UserRepository

    fun `test can insert user`() {
    }

}
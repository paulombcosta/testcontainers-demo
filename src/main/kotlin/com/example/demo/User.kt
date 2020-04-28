package com.example.demo

import javax.persistence.Id
import javax.persistence.Table

@Table(name = "users")
data class User(
        @Id
        val id: Int,
        val firstName: String,
        val lastName: String
)

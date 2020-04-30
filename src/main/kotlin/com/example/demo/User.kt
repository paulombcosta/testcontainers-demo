package com.example.demo

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
        @Id
        val id: Int,
        val firstName: String,
        val lastName: String
)

package com.example.api

data class UserModel(
    val address: Address,
    val email: String,
    val id: Int,
    val name: String,
    val username: String
)
package com.example.api


data class CommentModel(
    val postId:Int?=null,
    val id:Int?=null,
    val name:String?=null,
    val email:String?=null,
    val body:String?=null
)

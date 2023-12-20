package com.example.api

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AlbumInterface {
    @GET("albums")
    fun getallalbums(): Observable<List<AblumModel>>

 @GET("photos")
    fun getallphotos(): Observable<List<ImageModel>>

@GET("todos")
    fun getallTodos(): Observable<List<TodoModel>>

@GET("users")
    fun getallUsers(): Observable<List<UserModel>>


    companion object{

        fun createRetrofit():AlbumInterface{
            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
            return (retrofit.create(AlbumInterface::class.java))
        }

    }
}
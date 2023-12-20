package com.example.api


import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")

    fun getallPosts(): Observable<List<ApiModel>>
    companion object Factory{

        fun createRetrofit(): PostApi {
            var retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
            return(retrofit.create(PostApi::class.java))
        }
    }
}
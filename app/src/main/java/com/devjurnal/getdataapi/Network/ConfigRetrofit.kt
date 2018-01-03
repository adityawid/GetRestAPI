package com.devjurnal.getdataapi.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by DevJurnal on 1/2/18.
 */
class ConfigRetrofit {

    val retrofit = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    // Service yang dipanggil di activity
    val service = retrofit.create<PostService>(PostService::class.java)
}
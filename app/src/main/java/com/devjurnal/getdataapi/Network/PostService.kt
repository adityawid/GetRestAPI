package com.devjurnal.getdataapi.Network

import com.devjurnal.getdataapi.Resources.ModelResponseComment
import com.devjurnal.getdataapi.Resources.ModelResponseServer
import retrofit2.Call
import retrofit2.http.*
import java.util.HashMap

/**
 * Created by DevJurnal on 1/1/18.
 */
interface PostService {

    @GET("/posts")
    abstract fun getAllPosts(): Call<List<ModelResponseServer>>

    @GET("/posts/{id}/comments")
    fun getAllComment(@Path("id") id: Int):Call<List<ModelResponseComment>>

    @GET("/posts/{id}")
    abstract fun getPostById(@Path("id") id: Int): Call<List<ModelResponseServer>>

    @POST("/posts")
    abstract fun createPost(@Body post: ModelResponseServer): Call<ModelResponseServer>


    @DELETE("/comments?postId={id}")
    fun deleteComment(@Path("id") id: Int): Call<List<ModelResponseComment>>

    @FormUrlEncoded
    @POST("/posts/1/comments")
    fun postComment(@Field ("id") id : Int,
                    @Field ("name") name : String, @Field ("email") email: String,
                    @Field ("body") body : String) : Call<ModelResponseComment>
@FormUrlEncoded
    @POST("/posts/1/comments")
    fun postHash( query: HashMap<String, String>) : Call<ModelResponseComment>

}
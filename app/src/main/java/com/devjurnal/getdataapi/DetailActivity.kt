package com.devjurnal.getdataapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.devjurnal.getdataapi.Network.ConfigRetrofit
import com.devjurnal.getdataapi.Resources.ModelResponseComment
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_dummy_post_comment.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    var DATA_EXTRA=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var id = intent.getStringExtra("id")
        var title = intent.getStringExtra("title")
        var body= intent.getStringExtra("body")

        title_post_detail.text = title
        body_post_detail.text = body
        Log.d("Eror server", id+title+body)
        var getConfig = ConfigRetrofit().service

        var getRequest = getConfig.getAllComment(id.toInt())
        getRequest.enqueue(object : Callback<List<ModelResponseComment>> {
            override fun onFailure(call: Call<List<ModelResponseComment>>?, t: Throwable?) {
                Log.d("Eror server", t?.message)
            }

            override fun onResponse(call: Call<List<ModelResponseComment>>?, response: Response<List<ModelResponseComment>>?) {
                // Get Data dari JSON
                if (response?.isSuccessful!!){
                    var allJSONComment = response?.body()

                    var adapter = CommentAdapter(allJSONComment,applicationContext)

                    recyclerViewDetail.adapter = adapter

                    recyclerViewDetail.layoutManager = LinearLayoutManager(applicationContext)

                }
            }

        })


        // Post Comment

        //Get All Post
        postNewComment.setOnClickListener {
            var postRequest = getConfig.postComment(502,nameComment.text.toString(),emailComment.text.toString(),
                    bodyComment.text.toString())

            postRequest.enqueue(object : Callback<ModelResponseComment> {
                override fun onFailure(call: Call<ModelResponseComment>?, t: Throwable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    Log.d("Eror server", t?.message)
                }

                override fun onResponse(call: Call<ModelResponseComment>?, response: Response<ModelResponseComment>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    if(response?.isSuccessful!!) {
                        Log.d("Respon Post", response?.body().toString())
                    }
                }

            })
        }



    }
}

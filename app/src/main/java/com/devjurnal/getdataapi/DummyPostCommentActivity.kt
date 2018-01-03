package com.devjurnal.getdataapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.devjurnal.getdataapi.Network.ConfigRetrofit
import com.devjurnal.getdataapi.Resources.ModelResponseComment
import com.devjurnal.getdataapi.Resources.ModelResponseServer
import kotlinx.android.synthetic.main.activity_dummy_post_comment.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DummyPostCommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy_post_comment)


        var getConfig = ConfigRetrofit().service

        var getRequest = getConfig.postComment(1,"","","")

        //Get All Post
        getRequest.enqueue(object : Callback<ModelResponseComment> {
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

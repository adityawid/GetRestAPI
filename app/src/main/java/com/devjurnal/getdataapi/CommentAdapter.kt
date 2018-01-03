package com.devjurnal.getdataapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.system.Os.remove
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devjurnal.getdataapi.Network.ConfigRetrofit
import com.devjurnal.getdataapi.Resources.ModelResponseComment
import com.devjurnal.getdataapi.Resources.ModelResponseServer
import kotlinx.android.synthetic.main.item_comment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by DevJurnal on 1/2/18.
 */
class CommentAdapter( allJSONComment: List<ModelResponseComment>?, context : Context) :
        RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {

    // ToDO (1)
    var allJSONComment: List<ModelResponseComment>?
    var context : Context

    init {

        this.allJSONComment=allJSONComment
        this.context=context
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_comment,parent,false)
        return CommentAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.bind(position,allJSONComment)
    }

    override fun getItemCount(): Int {
        return allJSONComment?.size!!
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, allJSONComment: List<ModelResponseComment>?) {

            itemView.item_name_comment.text = allJSONComment?.get(position)?.name
            itemView.item_email_comment.text = allJSONComment?.get(position)?.email
            itemView.item_body_comment.text = allJSONComment?.get(position)?.body

            var postid = allJSONComment?.get(position)?.postId

            itemView.setOnClickListener({
                var getRequest = ConfigRetrofit().service.deleteComment(postid!!)
                getRequest.enqueue(object : Callback<List<ModelResponseComment>> {
                    override fun onFailure(call: Call<List<ModelResponseComment>>?, t: Throwable?) {
                        Log.d("Eror server", t?.message)
                    }

                    override fun onResponse(call: Call<List<ModelResponseComment>>?, response: Response<List<ModelResponseComment>>?) {
                        response?.body()
                    }

                })
            })
        }
    }
}
package com.devjurnal.getdataapi

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devjurnal.getdataapi.R.id.recyclerView
import com.devjurnal.getdataapi.Resources.ModelResponseServer
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by DevJurnal on 1/2/18.
 */
class PostAdapter(allJSON: List<ModelResponseServer>?, context : Context) : RecyclerView.Adapter<PostAdapter.MyViewHolder>(){

    // ToDO (1)
    var allJSON: List<ModelResponseServer>?
    var context : Context

    init {
        this.allJSON=allJSON
        this.context=context
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // TODO (2) tambah view
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        // TODO (5) json size
        return allJSON?.size!!
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        TODO (3) Create Function >>> Alt+Enter >> Member
        holder?.bind(position,allJSON)
        /*holder?.itemView?.setOnClickListener({
            var intent = Intent(context,DetailActivity::class.java)
            var model = ModelResponseServer(allJSON?.get(position)?.id, allJSON?.get(position)?.title,
                    allJSON?.get(position)?.body)
            intent.putExtra(DetailActivity().DATA_EXTRA,model)
            context.startActivity(intent)
        })*/
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        // Todo (4) isi fungsi bind
        fun bind(position: Int, allJSON: List<ModelResponseServer>?) {
            itemView.item_title.text = allJSON?.get(position)?.title

            itemView?.setOnClickListener({
                var intent = Intent(itemView.context,DetailActivity::class.java)
                intent.putExtra("id",allJSON?.get(position)?.id.toString())
                intent.putExtra("title",allJSON?.get(position)?.title)
                intent.putExtra("body",allJSON?.get(position)?.body)
                itemView.context.startActivity(intent)
            })

        }
    }
}
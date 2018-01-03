package com.devjurnal.getdataapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.devjurnal.getdataapi.Network.ConfigRetrofit
import com.devjurnal.getdataapi.Resources.ModelResponseServer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var getConfig = ConfigRetrofit().service

        var getRequest = getConfig.getAllPosts()


        //Get All Post
        getRequest.enqueue(object : Callback<List<ModelResponseServer>> {
            override fun onFailure(call: Call<List<ModelResponseServer>>?, t: Throwable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.d("Eror server", t?.message)
            }

            override fun onResponse(call: Call<List<ModelResponseServer>>?, response: Response<List<ModelResponseServer>>?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                // Get Data dari JSON
                if (response?.isSuccessful!!){
                    var allJSON = response.body()

                    var adapter = PostAdapter(allJSON,applicationContext)

                    recyclerView.adapter = adapter

                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)

                }
            }

        })
    }
}


/*
initViews()

val retrofit = Retrofit.Builder()
        .baseUrl("http://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val postService = retrofit.create<PostService>(PostService::class.java!!)

getAllPosts(postService)

*/
/*Post newPost = new Post();
        newPost.setId(100);
        newPost.setUserId(200);
        newPost.setTitle("Sample title");
        newPost.setBody("Sample data.");
        createPost(postService, newPost);*//*


}

private fun createPost(postService: PostService, newPost: Post) {

    val call = postService.createPost(newPost)
    call.enqueue(object : Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
            displayPost(response.body())
        }

        override fun onFailure(call: Call<Post>, t: Throwable) {
            Toast.makeText(getApplicationContext(), "Unable to create post", Toast.LENGTH_LONG).show()
            Log.e(TAG, t.toString())
        }
    })
}

private fun getAllPosts(postService: PostService) {
    val getAllPostsCall = postService.getAllPosts()

    getAllPostsCall.enqueue(object : Callback<List<Post>> {
        override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
            displayPost(response.body()!![0])
        }

        override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            Log.e(TAG, "Error occured while fetching post.")
        }
    })
}

private fun initViews() {
    this.postId = findViewById(R.id.postId) as TextView
    this.postTitle = findViewById(R.id.postTitle) as TextView
    this.postText = findViewById(R.id.postText) as TextView
}

private fun displayPost(post: Post?) {
    postId.setText("halo")
    postTitle.setText(post!!.getTitle())
    postText.setText(post!!.getBody())
}*/

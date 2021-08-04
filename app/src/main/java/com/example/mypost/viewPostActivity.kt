package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class viewPostActivity : AppCompatActivity() {
    var postId=0
    lateinit var tvuser2:TextView
    lateinit var tvpost:TextView
    lateinit var rvComments: RecyclerView
    lateinit var tvComments: TextView
    lateinit var tvBody: TextView
    lateinit var tvid: TextView
    lateinit var tvName: TextView
    lateinit var tvEmail: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_post)
        postId=intent.getIntExtra("POST_ID",0)

        tvuser2=findViewById(R.id.tvuser2)
        tvpost=findViewById(R.id.tvpost)
        tvid=findViewById(R.id.tvid)
        tvName=findViewById(R.id.tvName)
        tvEmail=findViewById(R.id.tvEmail)
        tvComments=findViewById(R.id.tvComment)
        rvComments=findViewById(R.id.rvComments)
        fetchPostById()
    }
    fun fetchPostById(){
        var apiclient=APIclient.buildAPIclient(ApiInterface::class.java)
        var request=apiclient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post=response.body()
                    tvuser2.text=post?.body
                    tvpost.text=post?.title

                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun getComments(){
        findViewById<RecyclerView>(R.id.rvComments)
        var api=APIclient.buildAPIclient(ApiInterface::class.java)
        var request =api.getComment()
        request.enqueue(object:Callback<List<Comments>>{

            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                var comment = response.body()!!
                var commentAdapter = CommentsViewHolder(Comments)
                rvComments.adapter =commentAdapter
                rvComments.layoutManager =LinearLayoutManager(baseContext)
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
            })
    }
}


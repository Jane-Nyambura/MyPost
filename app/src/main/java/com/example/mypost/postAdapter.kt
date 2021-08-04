package com.example.mypost

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class postAdapter(var postList: List<Post>,var context:Context):RecyclerView.Adapter<postViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item,parent,false)
        return postViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        var currentPost=postList.get(position)
        holder.tvuserid.text=currentPost.userId.toString()
        holder.tvId.text= currentPost.id.toString()
        holder.tvtitle.text=currentPost.title
        holder.tvbody.text=currentPost.body
        holder.cvPost.setOnClickListener{
            var intent=Intent(context,viewPostActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
//            intent.addFlags(intent.)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class postViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var tvuserid = itemView.findViewById<TextView>(R.id.tvComment)
    var tvId = itemView.findViewById<TextView>(R.id.tvid)
    var tvtitle = itemView.findViewById<TextView>(R.id.tvName)
    var tvbody = itemView.findViewById<TextView>(R.id.tvBody)
    var cvPost=itemView.findViewById<CardView>(R.id.cvPost)
}
package com.example.mypost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class postAdapter(var postList: List<Post>):RecyclerView.Adapter<postViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item,parent,false)
        return postViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        var currentPost=postList.get(position)
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class postViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var tvuserid = itemView.findViewById<TextView>(R.id.tvuserid)
    var tvId = itemView.findViewById<TextView>(R.id.tvId)
    var tvtitle = itemView.findViewById<TextView>(R.id.tvtitle)
    var tvbody = itemView.findViewById<TextView>(R.id.tvbody)
}
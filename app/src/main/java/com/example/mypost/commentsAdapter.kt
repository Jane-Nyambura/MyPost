package com.example.mypost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Comment

class commentsAdapter (var commentList: List<Comments>):RecyclerView.Adapter<CommentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_list_item,parent,false)
        return CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment = commentList.get(position)
            holder.tvComment.text = currentComment.comments.toString()
            holder.tvid.text = currentComment.id.toString()
            holder.tvName.text = currentComment.name
            holder.tvEmail.text = currentComment.email
            holder.tvBody.text = currentComment.Body

        }


    override fun getItemCount(): Int {
        return commentList.size
    }
}
class CommentsViewHolder(var item:View):RecyclerView.ViewHolder(item){
    var tvComment=itemView.findViewById<TextView>(R.id.tvComment)
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvid=itemView.findViewById<TextView>(R.id.tvid)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
}
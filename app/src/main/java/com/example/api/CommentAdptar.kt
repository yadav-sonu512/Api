package com.example.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdptar: RecyclerView.Adapter<CommentAdptar.ApiViewHolder>() {
    private var dataList: List<CommentModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_layout, parent, false)
        return ApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dataList: List<CommentModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }


    inner class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userid = itemView.findViewById<TextView>(R.id.CpostId)
        private val id = itemView.findViewById<TextView>(R.id.Cid)
        private val name = itemView.findViewById<TextView>(R.id.Cname)
        private val email = itemView.findViewById<TextView>(R.id.Cemail)
        private val body = itemView.findViewById<TextView>(R.id.Cbody)

        fun bindData(data: CommentModel) {
            userid.text = data.postId.toString()
            id.text = data.id.toString()
            name.text = data.name
            email.text=data.email
            body.text = data.body
        }
    }
}
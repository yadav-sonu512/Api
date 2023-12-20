package com.example.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdptar: RecyclerView.Adapter<UserAdptar.ApiViewHolder>() {
    private var dataList: List<UserModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false)
        return ApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dataList: List<UserModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    inner class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val id = itemView.findViewById<TextView>(R.id.userid)
        private val name = itemView.findViewById<TextView>(R.id.uname)
        private val username = itemView.findViewById<TextView>(R.id.username)
        private val email = itemView.findViewById<TextView>(R.id.email)
        private val address = itemView.findViewById<TextView>(R.id.address)

        fun bindData(data: UserModel) {
            id.text = data.id.toString()
            name.text = data.name
            username.text = data.username
            email.text = data.email
            address.text = data.address.toString()
        }
    }
}
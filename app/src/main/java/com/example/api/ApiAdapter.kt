package com.example.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApiAdapter : RecyclerView.Adapter<ApiAdapter.ApiViewHolder>() {
    private var dataList: List<ApiModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout, parent, false)
        return ApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dataList: List<ApiModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    inner class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userid = itemView.findViewById<TextView>(R.id.useridText)
        private val id = itemView.findViewById<TextView>(R.id.idText)
        private val title = itemView.findViewById<TextView>(R.id.titleText)
        private val body = itemView.findViewById<TextView>(R.id.bodyText)

        fun bindData(data: ApiModel) {
            userid.text = data.userId.toString()
            id.text = data.id.toString()
            title.text = data.title
            body.text = data.body
        }
    }
}

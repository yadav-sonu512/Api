package com.example.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class AlbumAdptar: RecyclerView.Adapter<AlbumAdptar.ApiViewHolder>() {
    private var dataList: List<AblumModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_layout, parent, false)
        return ApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dataList: List<AblumModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }


    inner class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val id = itemView.findViewById<TextView>(R.id.AId)
        private val title = itemView.findViewById<TextView>(R.id.Atitle)
        private val userid = itemView.findViewById<TextView>(R.id.Auserid)

        fun bindData(data: AblumModel) {
            userid.text = data.userId.toString()
            id.text = data.id.toString()
            title.text = data.title


        }
    }
}
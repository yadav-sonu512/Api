package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.currentCoroutineContext

class photoAdptar(private val context: Context) : RecyclerView.Adapter<photoAdptar.ApiViewHolder>() {
    private var dataList: List<ImageModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_layout, parent, false)
        return ApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val data = dataList[position]
     holder.title.text="Title:${data.title}"
       Glide.with(context).load(data.url).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dataList: List<ImageModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }


    inner class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val title = itemView.findViewById<TextView>(R.id.phototitlr)
        val imageView = itemView.findViewById<ImageView>(R.id.imagdeview)



        fun bindData(data: ImageModel) {

            title.text=data.title
           Glide.with(context).load(data.url).into(imageView)
        }
    }
}
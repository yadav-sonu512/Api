package com.example.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdptar: RecyclerView.Adapter<TodoAdptar.ApiViewHolder>() {
    private var dataList: List<TodoModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_layout, parent, false)
        return ApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindData(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dataList: List<TodoModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    inner class ApiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userid = itemView.findViewById<TextView>(R.id.todouserid)
        private val id = itemView.findViewById<TextView>(R.id.todoid)
        private val title = itemView.findViewById<TextView>(R.id.todotitle)
        private val completed = itemView.findViewById<TextView>(R.id.todocompleted)

        fun bindData(data: TodoModel) {
            userid.text = data.userId.toString()
            id.text = data.id.toString()
            title.text = data.title
            completed.text = data.completed.toString()
        }
    }
}
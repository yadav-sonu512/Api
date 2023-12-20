package com.example.api

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TodoActivity : AppCompatActivity() {
    private lateinit var todoAdptar: TodoAdptar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val albumbutton=findViewById<ImageView>(R.id.todobackbutton)
        albumbutton.setOnClickListener {
            onBackPressed()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.todorecyclerview)
        todoAdptar = TodoAdptar()
        recyclerView.adapter = todoAdptar
        recyclerView.layoutManager = LinearLayoutManager(this)

        AlbumInterface.createRetrofit().getallTodos()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
//                userid.text= it[1].userId.toString()
//                id.text=it[1].id.toString()
//                title.text=it[1].title
//                body.text=it[1].body
                todoAdptar.setData(it)
                Toast.makeText(this, "Album Data get is successfull", Toast.LENGTH_SHORT).show()
            },{
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
            )
    }
}
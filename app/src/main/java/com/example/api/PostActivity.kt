package com.example.api

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostActivity : AppCompatActivity() {
    private lateinit var adapter: ApiAdapter
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        //        val userid = findViewById<TextView>(R.id.userid)
//        val id = findViewById<TextView>(R.id.id)
//        val title = findViewById<TextView>(R.id.title)
//        val body = findViewById<TextView>(R.id.body)
        val backbutton=findViewById<ImageView>(R.id.backbutton)
        backbutton.setOnClickListener {
            onBackPressed()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        adapter = ApiAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        PostApi.createRetrofit().getallPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
//                userid.text= it[1].userId.toString()
//                id.text=it[1].id.toString()
//                title.text=it[1].title
//                body.text=it[1].body
                adapter.setData(it)
                Toast.makeText(this, "Data get is successfull", Toast.LENGTH_SHORT).show()
            },{
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
            )
    }
}
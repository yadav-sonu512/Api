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

class CommentActivity : AppCompatActivity() {
    private lateinit var commentadptar: CommentAdptar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
        //        val userid = findViewById<TextView>(R.id.userid)
//        val id = findViewById<TextView>(R.id.id)
//        val title = findViewById<TextView>(R.id.title)
//        val body = findViewById<TextView>(R.id.body)
        val commentbutton=findViewById<ImageView>(R.id.commentbackbutton)
        commentbutton.setOnClickListener {
            onBackPressed()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        commentadptar = CommentAdptar()
        recyclerView.adapter = commentadptar
        recyclerView.layoutManager = LinearLayoutManager(this)

        commentInterface.createRetrofit().getallposts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
//                userid.text= it[1].userId.toString()
//                id.text=it[1].id.toString()
//                title.text=it[1].title
//                body.text=it[1].body
                commentadptar.setData(it)
                Toast.makeText(this, "Comment Data get is successfull", Toast.LENGTH_SHORT).show()
            },{
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
            )
    }
}
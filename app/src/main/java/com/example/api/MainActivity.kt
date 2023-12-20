package com.example.api

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val postApi=findViewById<Button>(R.id.postApiButton)
        postApi.setOnClickListener {
            startActivity(Intent(this,PostApiActivity::class.java))
        }
        val post=findViewById<TextView>(R.id.post)
        val comment=findViewById<TextView>(R.id.comment)
        val album=findViewById<TextView>(R.id.album)
        val photo=findViewById<TextView>(R.id.photo)
        val todo=findViewById<TextView>(R.id.todo)
        val user=findViewById<TextView>(R.id.user)

        post.setOnClickListener {
            val intent=Intent(this@MainActivity, PostActivity::class.java)
            startActivity(intent)
        }
        comment.setOnClickListener {
            val intent=Intent(this,CommentActivity::class.java)
            startActivity(intent)
        }
        album.setOnClickListener {
            startActivity(Intent(this,AlbumActivity::class.java))
        }
        photo.setOnClickListener {
            startActivity(Intent(this,PhotoActivity::class.java))
        }
        todo.setOnClickListener {
            startActivity(Intent(this,TodoActivity::class.java))
        }
        user.setOnClickListener {
            startActivity(Intent(this,UserActivity::class.java))
        }
    }
}
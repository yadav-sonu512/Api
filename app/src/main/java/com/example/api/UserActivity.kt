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

class UserActivity : AppCompatActivity() {
    private lateinit var userAdptar: UserAdptar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        //        val userid = findViewById<TextView>(R.id.userid)
//        val id = findViewById<TextView>(R.id.id)
//        val title = findViewById<TextView>(R.id.title)
//        val body = findViewById<TextView>(R.id.body)
        val backbutton=findViewById<ImageView>(R.id.userbackbutton)
        backbutton.setOnClickListener {
            onBackPressed()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.userrecyclerview)
        userAdptar = UserAdptar()
        recyclerView.adapter = userAdptar
        recyclerView.layoutManager = LinearLayoutManager(this)

        AlbumInterface.createRetrofit().getallUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
//                userid.text= it[1].userId.toString()
//                id.text=it[1].id.toString()
//                title.text=it[1].title
//                body.text=it[1].body
                userAdptar.setData(it)
                Toast.makeText(this, "User data get is successfull", Toast.LENGTH_SHORT).show()
            },{
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
            )
    }
}
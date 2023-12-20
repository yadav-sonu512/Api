package com.example.api

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotoActivity : AppCompatActivity() {

    private lateinit var imageadptar: photoAdptar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

            val photobutton=findViewById<ImageView>(R.id.photobackbutton)
            photobutton.setOnClickListener {
                onBackPressed()
            }
            val recyclerView = findViewById<RecyclerView>(R.id.photorecyclerview)
            imageadptar = photoAdptar(this)
            recyclerView.adapter = imageadptar
            recyclerView.layoutManager =GridLayoutManager(this,2)

            AlbumInterface.createRetrofit().getallphotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
//                userid.text= it[1].userId.toString()
//                id.text=it[1].id.toString()
//                title.text=it[1].title
//                body.text=it[1].body
                    imageadptar.setData(it)
                    Toast.makeText(this, "Image Data get is successfull", Toast.LENGTH_SHORT).show()
                },{
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                )
        }
    }
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
import com.example.api.AlbumAdptar

class AlbumActivity : AppCompatActivity() {
    private lateinit var Albumadptar: AlbumAdptar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        val albumbutton=findViewById<ImageView>(R.id.Albumbackbutton)
        albumbutton.setOnClickListener {
            onBackPressed()
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        Albumadptar =AlbumAdptar()
        recyclerView.adapter = Albumadptar
        recyclerView.layoutManager = LinearLayoutManager(this)

        AlbumInterface.createRetrofit().getallalbums()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
//                userid.text= it[1].userId.toString()
//                id.text=it[1].id.toString()
//                title.text=it[1].title
//                body.text=it[1].body
                Albumadptar.setData(it)
                Toast.makeText(this, "Album Data get is successfull", Toast.LENGTH_SHORT).show()
            },{
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
            )
    }
}
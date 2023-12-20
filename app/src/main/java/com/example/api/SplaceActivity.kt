package com.example.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

class SplaceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)

        Handler().postDelayed({
//            if (auth.currentUser?.uid!=null){
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
           // }
//            else{
//                val intent= Intent(this,MainActivity::class.java)
//                startActivity(intent)
//                Toast.makeText(this, "fill the virefication", Toast.LENGTH_SHORT).show()
//            }
        },2000)
    }
}
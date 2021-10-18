package com.example.multipleactivitiesbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity3 : AppCompatActivity() {
    lateinit var rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        rv=findViewById(R.id.rv)

        val output= intent.extras?.get("information") as ArrayList<String>

        rv.adapter=myAdapter(output as ArrayList<String>)
        rv.layoutManager= LinearLayoutManager(this)
    }
}
package com.example.multipleactivitiesbonus

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.collections.ArrayList as ArrayList

class MainActivity2 : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button2: Button
    lateinit var output:ArrayList<String>
    var output2=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView=findViewById(R.id.textView)
        button2=findViewById(R.id.button2)

         output= intent.extras?.get("information") as ArrayList<String>
         output2="Name:${output[0]}\nLocation:${output[1]}\nMobile:${output[2]}\nE-mail:${output[3]}\n"
        textView.text=output2
        button2.setOnClickListener {
            customalert()
        }
    }

    fun customalert(){
        val builder = AlertDialog.Builder(this)
        val text=TextView(this)
        text.text=output2
        builder.setPositiveButton("Conform", DialogInterface.OnClickListener{
                dialog, id -> val intent=Intent(this,MainActivity3::class.java);intent.putExtra("information",output);startActivity(intent)
        })

        val alert = builder.create()
        alert.setTitle("Conform")
        alert.setView(text)
        alert.show()
    }
}
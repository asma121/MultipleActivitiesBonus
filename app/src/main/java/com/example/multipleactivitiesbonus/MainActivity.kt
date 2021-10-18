package com.example.multipleactivitiesbonus

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var et1:EditText
    lateinit var et2:EditText
    lateinit var et3:EditText
    lateinit var et4:EditText
    lateinit var button: Button
    lateinit var checkBox: CheckBox
    lateinit var informaion:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1=findViewById(R.id.et1)
        et2=findViewById(R.id.et2)
        et3=findViewById(R.id.et3)
        et4=findViewById(R.id.et4)
        button=findViewById(R.id.button)
        checkBox=findViewById(R.id.checkBox)
        informaion= arrayListOf()

        button.setOnClickListener {
            if (checkBox.isChecked){
                if (et1.text.isNotEmpty() && et2.text.isNotEmpty() && et3.text.isNotEmpty () && et4.text.isNotEmpty()){
                    informaion= arrayListOf("${et1.text}","${et2.text}","${et3.text}","${et4.text}")
                    val intent= Intent(this,MainActivity2::class.java)
                    intent.putExtra("information",informaion)
                    startActivity(intent)
                }else{
                    Toast.makeText(this," one filed or more are empty",Toast.LENGTH_LONG).show()
                }
            }else{
                customalert()
            }
        }
    }

    fun customalert(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("please check the checkbox")
        builder.setPositiveButton("Ok", DialogInterface.OnClickListener{
                dialog, id -> dialog.cancel()
        })

        val alert = builder.create()
        alert.setTitle("check")
        alert.show()
    }
}
package com.example.visualtesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        asd()
    }

    private fun asd() {
        val btn = findViewById<Button>(R.id.btn_continue)
        val nombre = findViewById<EditText>(R.id.et_nombre)
        val contrasenia = findViewById<EditText>(R.id.et_contraseña)

        btn.setOnClickListener {

            if (nombre.text.toString() == "" || contrasenia.text.toString() == ""){
                Toast.makeText(this,"complete los datos",Toast.LENGTH_LONG).show()
            } else {
                startActivity(Intent(this, MainActivity2::class.java))
                //Toast.makeText(this,"usted ingreso",Toast.LENGTH_LONG).show()
            }
        }
    }
}
package com.example.italocachorrosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cadastrar(view: View) {
        val mIntent = Intent(this, TelaCadastro::class.java)
        startActivity(mIntent)
    }
    fun listarCachorros(view: View) {
        val mIntent = Intent(this, ListaDeCachorros::class.java)
        startActivity(mIntent)
    }
}
package com.example.italocachorrosapp

import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class TelaCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro)


    }

    fun cadastrar(view: View) {

        val raca:EditText = findViewById(R.id.et_raca)
        val valor:EditText = findViewById(R.id.et_preco)
        val indicadoParaCriancas:Switch = findViewById(R.id.sw_crianca)

        if(raca.text.isBlank() || valor.text.isBlank()){
            Toast.makeText(this, "Preencha todos os campos!!", Toast.LENGTH_SHORT).show()
        }else{
            val nomeRaca:String = raca.text.toString();
            val custoTotal:Int = valor.text.toString().toInt();
            val crianca:Boolean = indicadoParaCriancas.isChecked

            val cachorro:Cachorros = Cachorros(nomeRaca,custoTotal,crianca)

            val apiCachorros = ConexaoCachorros.criar()

            apiCachorros.post(cachorro).enqueue(object : Callback<Cachorros>{
                override fun onResponse(call: Call<Cachorros>, response: Response<Cachorros>) {
                    Log.println(Log.INFO, "merda",response.toString())
                    Toast.makeText(this@TelaCadastro, "success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Cachorros>, t: Throwable) {
                    Log.println(Log.INFO, "merda",t.toString())
                    Toast.makeText(this@TelaCadastro, "erro", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}
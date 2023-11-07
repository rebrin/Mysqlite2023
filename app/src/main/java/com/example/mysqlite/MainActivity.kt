package com.example.mysqlite

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.mysqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.btnMostrar.setOnClickListener({
            val intent=Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        })

    }

    fun guardar(view:View){
        val miOpenHelper=MiOpenHelper(this)
        val db=miOpenHelper.writableDatabase
        //obtener los valores del elemento
        val titulo=binding.etNota.text.toString()
        val descripNota=binding.etDesc.text.toString()

        //creamos el cv
        val contentValues=ContentValues().apply{
            put(NotasContract.Registros.colTitulo,titulo)
            put(NotasContract.Registros.colDescripcion,descripNota)
        }
        val nuevoID=db.insert(NotasContract.Registros.TABLE_NAME
            ,null,
            contentValues)
        Log.d("misqlite","insertado:${nuevoID}")
        //limipamos las entradas
        binding.etNota.setText("")
        binding.etDesc.setText("")
    }
}
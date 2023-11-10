package com.example.mysqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import com.example.mysqlite.databinding.ActivityEliminationBinding
import com.example.mysqlite.databinding.ActivityMain2Binding

class Elimination : AppCompatActivity() {
    lateinit var binding: ActivityEliminationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEliminationBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.btnElimina.setOnClickListener({
//            val eliminar=binding.TvIdEliminar.text.toString()
//            val db=MiOpenHelper(this).writableDatabase
//            val condicion="${NotasContract.Registros.id}=?"
//            val valoresCond= arrayOf(eliminar)
//            val cuantas=db.delete(NotasContract.Registros.TABLE_NAME,condicion,valoresCond)
//            Toast.makeText(applicationContext,"eliminada ${cuantas} filas",Toast.LENGTH_LONG)
//                .show()
            val inflador= layoutInflater
            //los parámetros son el layout templete y el viewgroup donde se va añadir
            val view = inflador.inflate(R.layout.layout_eliminacion,
                findViewById(R.id.linearLayoutgroup))

        })
    }
}
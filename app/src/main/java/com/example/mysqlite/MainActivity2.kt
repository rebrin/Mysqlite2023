package com.example.mysqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.mysqlite.databinding.ActivityMain2Binding
import com.example.mysqlite.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

//    lateinit var binding: ActivityMain2Binding
lateinit var contenedorNotas:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMain2Binding.inflate(layoutInflater)
//        val view = binding.root
        setContentView(R.layout.activity_main2)
        val inflador = layoutInflater
        contenedorNotas=findViewById(R.id.contenedorNotas)
        contenedorNotas.removeAllViews()
        val miOpenHelper = MiOpenHelper(this)
        val bd = miOpenHelper.readableDatabase
        val columnas = arrayOf(
            NotasContract.Registros.id,
            NotasContract.Registros.colTitulo,
            NotasContract.Registros.colDescripcion
        )
        val cursor = bd.query(
            NotasContract.Registros.TABLE_NAME,
            columnas,
            null, null, null, null, null, null
        )
        var pos=0
        //muevo al inicio
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                val id = cursor.getInt(0)
                val titulo = cursor.getString(1)
                val desc = cursor.getString(2)
                //binding.tvGuardados.append("\n ${id}:${titulo} ${desc}")
                Log.d("datos", "${id}:${titulo} ${desc}")
                val vista = inflador.inflate(
                    R.layout.layout_notas,
                    contenedorNotas, false
                )
                vista.findViewById<TextView>(R.id.tvTitulo).text = titulo
                vista.findViewById<TextView>(R.id.tvNota).text = desc
                vista.findViewById<Button>(R.id.btnEliminar).setOnClickListener {
                    //abro la vista en modo lectura
                    contenedorNotas = findViewById(R.id.contenedorNotas)
                    val db = MiOpenHelper(this).writableDatabase
                    val condicion = "${NotasContract.Registros.id}=?"
                    val valoresCond = arrayOf(id.toString())
                    //borro el registro
                    val cuantas = db.delete(
                        NotasContract.Registros.TABLE_NAME, condicion, valoresCond
                    )
                    if (cuantas > 0) {
                        //contenedorNotas.removeViewAt(pos)
                        contenedorNotas.removeView(it)
                        Toast.makeText(applicationContext,"eliminada nota:${titulo}",Toast.LENGTH_LONG).show()
                    }
                    finish()
                }
                contenedorNotas.addView(vista, 1064, 250)
                cursor.moveToNext()
                pos++
            }
        }

    }

}
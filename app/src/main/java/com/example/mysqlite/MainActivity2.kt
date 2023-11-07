package com.example.mysqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mysqlite.databinding.ActivityMain2Binding
import com.example.mysqlite.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        val miOpenHelper=MiOpenHelper(this)
        val bd=miOpenHelper.readableDatabase
        val columnas= arrayOf(
            NotasContract.Registros.id
            ,NotasContract.Registros.colTitulo
            ,NotasContract.Registros.colDescripcion)

        val cursor=bd.query(
            NotasContract.Registros.TABLE_NAME,
            columnas,
            null,null,null,null,null,null
        )
        //muevo al inicio
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                val id=cursor.getInt(0)
                val titulo=cursor.getString(1)
                val desc=cursor.getString(2)
                binding.tvGuardados.append("\n ${id}:${titulo} ${desc}")
                cursor.moveToNext()
            }
        }


    }


}
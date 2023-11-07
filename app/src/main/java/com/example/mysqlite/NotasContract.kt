package com.example.mysqlite

import android.provider.BaseColumns

object NotasContract {
   object Registros: BaseColumns {
        val TABLE_NAME="notas"
        val id="id_nota"
        val colTitulo="titulo"
        val colDescripcion="descripcion"
       val dbName="notas.db"

       val version=1
    }
}
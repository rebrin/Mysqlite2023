package com.example.mysqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MiOpenHelper(context: Context): SQLiteOpenHelper(context,
    NotasContract.Registros.dbName,null
    ,NotasContract.Registros.version) {
    val queryStart="create table ${NotasContract.Registros.TABLE_NAME} (" +
            "${NotasContract.Registros.id} integer primary key autoincrement," +
            "${NotasContract.Registros.colTitulo} text," +
            "${NotasContract.Registros.colDescripcion} text)"
    val borrarTabla="drop table if exists ${NotasContract.Registros.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(borrarTabla)
        db!!.execSQL(queryStart)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(borrarTabla)
        db!!.execSQL(queryStart)
    }
}
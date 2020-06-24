package com.example.ezytapexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver :BroadcastReceiver()
{
    override fun onReceive(context: Context?, intent: Intent?) {
        val data = intent!!.getStringExtra("data")
        Log.i("BR", "Data received:  $data")
        //Toast.makeText(context,"$data",Toast.LENGTH_SHORT).show()
        MainActivity.getInstance().updateUi(data)
    }

}
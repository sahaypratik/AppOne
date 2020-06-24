package com.example.ezytapexample

import android.app.Activity
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lib.MathOpsImpl
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var ops=MathOpsImpl()
    var myReceiver=MyReceiver()

    companion object{

        lateinit var activity: MainActivity

        public fun getInstance(): MainActivity {
            return activity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity=this
        /*if (!intent.action!!.equals("RESULT"))
        a.add(1,2,this)*/

        val intentFilter = IntentFilter("com.pkg.perform.Calculation")
        intentFilter?.let { registerReceiver(myReceiver, it) }

        btAdd.setOnClickListener {
            tvInputOne.text= "Input One - "+etInputOne.text.toString()
            tvInputTwo.text= "Input Two - "+etInputTwo.text.toString()
            tvAction.text= "Action - Addition"
            ops.add((etInputOne.text.toString()).toInt(),(etInputTwo.text.toString()).toInt(),this)

        }

        btSub.setOnClickListener {
            tvInputOne.text= "Input One - "+etInputOne.text.toString()
            tvInputTwo.text= "Input Two - "+etInputTwo.text.toString()
            tvAction.text= "Action - Subtraction"
            ops.sub((etInputOne.text.toString()).toInt(),(etInputTwo.text.toString()).toInt(),this)

        }

    }


    fun updateUi(output:String)
    {
        tvOutput.text= "Output is - $output"
    }


}

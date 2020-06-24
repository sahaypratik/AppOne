package com.example.lib

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat.startActivity


class MathOpsImpl:MathOps {
    override fun sub(inputOne: Int, inputTwo: Int,activity:Activity) {
        var intent=Intent()
        val manager: PackageManager =activity.packageManager
        try {
            intent = manager.getLaunchIntentForPackage("com.example.apptwo")!!
            if (intent == null) throw PackageManager.NameNotFoundException()
            intent.action = "COMPUTE"
            intent.putExtra("input1",inputOne)
            intent.putExtra("input2",inputTwo)
            intent.putExtra("type","sub")

            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            activity.startActivityForResult(intent,112)
        } catch (e: PackageManager.NameNotFoundException) {
        }
    }

    override fun add(inputOne: Int, inputTwo: Int,activity:Activity) {

        var intent=Intent()
        val manager: PackageManager =activity.packageManager
        try {
            intent = manager.getLaunchIntentForPackage("com.example.apptwo")!!
            if (intent == null) throw PackageManager.NameNotFoundException()
            intent.action = "COMPUTE"
            intent.putExtra("input1",inputOne)
            intent.putExtra("input2",inputTwo)
            intent.putExtra("type","add")

            intent.addCategory(Intent.CATEGORY_LAUNCHER)
           activity.startActivityForResult(intent,112)
        } catch (e: PackageManager.NameNotFoundException) {
        }
    }

}
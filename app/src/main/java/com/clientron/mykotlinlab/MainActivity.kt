package com.clientron.mykotlinlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculation.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            buttonCalculation.id -> {
                if (et_height.text.isNotEmpty() && et_weight.text.isNotEmpty()){
                    tv_bmi.text = "%.1f".format(calculationBMI(et_height.text.toString().toDouble(), et_weight.text.toString().toDouble()))
                }
            }
        }
    }

    private fun calculationBMI(h: Double, w: Double) : Double{
        return w / h.pow(2) * 10000
    }
}
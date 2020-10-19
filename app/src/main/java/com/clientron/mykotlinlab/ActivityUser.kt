package com.clientron.mykotlinlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class ActivityUser : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_user)
        val message = intent.getStringExtra("EXTRA_KEY")
        Toast.makeText(this,"$message 成功登入!!",Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View) {

    }

}
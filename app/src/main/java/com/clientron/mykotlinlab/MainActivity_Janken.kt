package com.clientron.mykotlinlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.layout_lab_janken.*


class MainActivity_Janken : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, View.OnClickListener{
    private val TAG = "MainActivity_Janken"
    private val JANKEN_ROCK = 0
    private val JANKEN_PAPER = 1
    private val JANKEN_SCISSORS = 2

    var janken = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_lab_janken)
        radioGroup.setOnCheckedChangeListener(this)
        btn_janken.setOnClickListener(this)
        radioGroup.clearCheck()
        Log.i(TAG, "onCreate: ")
    }

    fun judgment(computer : Int, self: Int){
        val name = et_name.text;
        when(computer){
            JANKEN_ROCK ->{
                if(self == JANKEN_ROCK){
                    tv_result.text = "平手 電腦: 石頭, $name: 石頭"
                }else if(self == JANKEN_PAPER){
                    tv_result.text = "$name 勝 電腦: 石頭, $name: 布"
                }else if(self == JANKEN_SCISSORS){
                    tv_result.text = "$name 敗 電腦: 石頭, $name: 剪刀"
                }
            }
            JANKEN_PAPER ->{
                if(self == JANKEN_ROCK){
                    tv_result.text = "$name 敗 電腦: 布, $name: 石頭"
                }else if(self == JANKEN_PAPER){
                    tv_result.text = "平手 電腦: 布, $name: 布"
                }else if(self == JANKEN_SCISSORS){
                    tv_result.text = "$name 勝 電腦: 布, $name: 剪刀"
                }
            }
            JANKEN_SCISSORS ->{
                if(self == JANKEN_ROCK){
                    tv_result.text = "$name 勝 電腦: 剪刀, $name: 石頭"
                }else if(self == JANKEN_PAPER){
                    tv_result.text = "$name 敗 電腦: 剪刀, $name: 布"
                }else if(self == JANKEN_SCISSORS){
                    tv_result.text = "平手 電腦: 剪刀, $name: 剪刀"
                }
            }
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when(p0?.id){
            radioGroup.id -> {
                when (p1) {
                    radioButton.id -> { janken = JANKEN_SCISSORS }
                    radioButton2.id -> { janken = JANKEN_ROCK }
                    radioButton3.id -> { janken = JANKEN_PAPER }
                }
            }
        }
    }
    var count = 0
    override fun onClick(p0: View?) {
        when(p0?.id){
            btn_janken.id -> {
                if(janken == -1) {
                    tv_result.text = "請選擇要出的拳"
                    return
                }else if(et_name.text.isEmpty()){
                    tv_result.text = "請輸入玩家姓名"
                    return
                }else {
//                    val random = (0..2).random()
//                    Log.i(TAG, "onClick: $random")
//                    judgment(random, janken)
                    radioGroup.clearCheck()
                    if(count == 5) {
                        count = 0
                        if(janken == JANKEN_ROCK) judgment(JANKEN_PAPER, janken)
                        else if(janken == JANKEN_PAPER) judgment(JANKEN_SCISSORS, janken)
                        else if(janken == JANKEN_SCISSORS) judgment(JANKEN_ROCK, janken)
                    }else{
                        count++ //count = count +1
                        if(janken == JANKEN_ROCK) judgment(JANKEN_SCISSORS, janken)
                        else if(janken == JANKEN_PAPER) judgment(JANKEN_ROCK, janken)
                        else if(janken == JANKEN_SCISSORS) judgment(JANKEN_PAPER, janken)
                    }
                }
            }
        }
    }

}
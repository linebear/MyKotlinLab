package com.clientron.mykotlinlab

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_login.*


class ActivityLogin : AppCompatActivity() , View.OnClickListener {

    private val USER_ID = "AAA"
    private val MANAGER_ID = "BBB"
    private val USER_PASSWORD = "123"
    private val MANAGER_PASSWORD = "456"

    private var isOpenEye = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)
        iv_eye.setOnClickListener(this)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            iv_eye.id -> {
                if(isOpenEye){
                    isOpenEye = false
                    iv_eye.isSelected = false
                    et_login_password.transformationMethod = PasswordTransformationMethod.getInstance() //不可見
                }else{
                    isOpenEye = true
                    iv_eye.isSelected = true
                    et_login_password.transformationMethod = HideReturnsTransformationMethod.getInstance()  //可見
                }
            }
            btn_login.id -> {
                if(et_login_id.text.isNotEmpty() && et_login_password.text.isNotEmpty()){
                    val id = et_login_id.text.toString()
                    val pw = et_login_password.text.toString()
                    if(id == USER_ID && pw == USER_PASSWORD){
//                        Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show()
                        val intent = Intent(this, ActivityUser::class.java)
                        intent.putExtra("EXTRA_KEY", id)
                        startActivity(intent)
                    }else if(id == MANAGER_ID && pw == MANAGER_PASSWORD){
//                        Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show()
                        val intent = Intent(this, ActivityManager::class.java)
                        intent.putExtra("EXTRA_KEY", id)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"請確認帳號密碼",Toast.LENGTH_LONG).show()
                    }
                }else Toast.makeText(this,"請輸入帳號密碼",Toast.LENGTH_LONG).show()
            }
        }
    }

}
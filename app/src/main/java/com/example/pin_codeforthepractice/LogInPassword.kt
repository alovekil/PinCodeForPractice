package com.example.pin_codeforthepractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create_password.*
import kotlinx.android.synthetic.main.fragment_create_password.view.*


class LogInPassword : Fragment() {
    var password1 = ""
    //var radio1true:CreatePassword?=null
    lateinit var sharedPreferenceManager: SahredPreferenceManager
    var radioList1: ArrayList<RadioButton> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_log_in_password, container, false)
        sharedPreferenceManager = SahredPreferenceManager()
        sharedPreferenceManager.getString("password","de")
        radioList1.add(view.radio1);
        radioList1.add(view.radio2);
        radioList1.add(view.radio3);
        radioList1.add(view.radio4);
        view.btnx.setOnClickListener { view ->
            if (password1.length > 0) {
                password1 = password1.substring(0, password1.length - 1)
               radio1true(password1.length)
                println(password1)
            }
        }
        view.btn0.setOnClickListener { view -> passwordCheck("0") }
        view.btn1.setOnClickListener { view -> passwordCheck("1") }
        view.btn2.setOnClickListener { view -> passwordCheck("2") }
        view.btn3.setOnClickListener { view -> passwordCheck("3") }
        view.btn4.setOnClickListener { view -> passwordCheck("4") }
        view.btn5.setOnClickListener { view -> passwordCheck("5") }
        view.btn6.setOnClickListener { view -> passwordCheck("6") }
        view.btn7.setOnClickListener { view -> passwordCheck("7") }
        view.btn8.setOnClickListener { view -> passwordCheck("8") }
        view.btn9.setOnClickListener { view -> passwordCheck("9") }

        return view
    }

    private fun radio1true(length: Int) {
        for(i in 0..4 ){
            if (i < length) {
                radioList1[i].isChecked = true
            } else {
                radioList1[i].isChecked = false
            }
        }
    }
    private fun passwordCheck(s: String) {
        if(password1!!.length<=3){
            password1+=s
            radio1true(password1.length)
        }

        checkpaswordequal()
    }

    private fun checkpaswordequal() {
        if (password1!!.length==4 ){
            if(password1.equals(sharedPreferenceManager.getString("password","00000000"))){
                textView.setVisibility(View.VISIBLE)
                Toast.makeText(getActivity() , "succes login" ,Toast.LENGTH_SHORT).show()
                /*val intent = Intent(this@Create_Password, ProfileActivity::class.java)
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                finish()*/
            }
            else{
                password1=""
               radio1true(password1.length)
            }
        }
    }


}
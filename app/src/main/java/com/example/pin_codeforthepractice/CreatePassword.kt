package com.example.pin_codeforthepractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.fragment_create_password.view.*


class CreatePassword : Fragment() {
    lateinit var sharedPreferenceManager: SahredPreferenceManager
    var radioList1: ArrayList<RadioButton> = ArrayList()
    var radioList2: ArrayList<RadioButton> = ArrayList()
    var password1:String? = ""
    var gpassword2:String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_create_password, container, false)
        sharedPreferenceManager = SahredPreferenceManager()
        radioList2.add(view.radio1);
        radioList2.add(view.radio2);
        radioList2.add(view.radio3);
        radioList2.add(view.radio4);
        radioList1.add(view.radio5);
        radioList1.add(view.radio6);
        radioList1.add(view.radio7);
        radioList1.add(view.radio8);
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

        view.btne.setOnClickListener { view -> this.activity?.finish() }
        view.btnx.setOnClickListener { view ->
            if (gpassword2!!.length > 0) {
                gpassword2 = gpassword2!!.substring(0, gpassword2!!.length - 1)
                radio2True(gpassword2!!.length)
                System.out.println(gpassword2)
            } else if (password1!!.length > 0) {
                password1 = password1!!.substring(0, password1!!.length - 1)
                radio1True(password1!!.length)
                System.out.println(password1)
            }
        }
        return view
    }

    private fun radio1True(length: Int) {
        for(i in 0..4 ){
            if(i<length){
                radioList1[i].isChecked = true
            }
            else{
                radioList1[i].isChecked = false
            }
        }
    }

    private fun radio2True(length: Int) {
        for(i in 0..4 ){
            if (i < length) {
                radioList2[i].isChecked = true
            } else {
                radioList2[i].isChecked = false
            }
        }
    }

    private fun passwordCheck(s: String) {
        if(password1!!.length<=3){
            password1+=s
            radio1True(password1!!.length)
        }
        else if(gpassword2!!.length<=3){
            gpassword2+=s
            radio2True(gpassword2!!.length)
        }
        checkpaswordequal()
    }

    private fun checkpaswordequal() {
        if (password1!!.length==4 && gpassword2!!.length==4){
            if(password1.equals(gpassword2)){
                view?.let { findNavController(it).navigate(R.id.navhost_create_to_login) }
                sharedPreferenceManager.setValue("password", password1!!)
                sharedPreferenceManager.setValue("create_password", true)

                Toast.makeText(this.activity,"Succesfully", Toast.LENGTH_LONG)
                /*val intent = Intent(this@Create_Password, ProfileActivity::class.java)
                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
                finish()*/
            }
            else{
                password1=""
                radio1True(password1!!.length)
                gpassword2=""
                radio2True(gpassword2!!.length)
            }
        }
    }


}
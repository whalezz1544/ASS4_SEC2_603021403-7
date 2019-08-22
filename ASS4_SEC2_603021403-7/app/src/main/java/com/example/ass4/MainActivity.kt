package com.example.ass4

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var radioGroup: RadioGroup = findViewById(R.id.radioGroup)
//        var selectedId:Int = radioGroup.checkedRadioButtonId;
//        var radioButton:RadioButton = findViewById(selectedId);
    }
    fun showDatePickerDialog(v: View){
        val newDatePickerFragment = DatePickerFragment()
        newDatePickerFragment.show(supportFragmentManager,"Date Picker")
    }
    fun showDetail(view:View){
        var radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        var selectedId:Int = radioGroup.checkedRadioButtonId
        var radioButton:RadioButton = findViewById(selectedId)
        text_show.text = "Username: ${inputUser.text}\nPassword: ${inputPass.text}\nGender: ${radioButton.text}\nEmail: ${inputEmail.text}\nBirthday: ${text_bd.text}"

    }
    fun reset(v: View){
        inputUser.text.clear()
        inputPass.text.clear()
        radioGroup.clearCheck()
        inputEmail.text.clear()
        text_bd.text="  _ / _ / _"
        text_show.text = "Show lnformation"
    }
}

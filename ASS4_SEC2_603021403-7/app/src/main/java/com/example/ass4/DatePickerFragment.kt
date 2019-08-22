package com.example.ass4

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.AbsListView
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.time.Year
import java.util.*

class DatePickerFragment: DialogFragment(),DatePickerDialog.OnDateSetListener{
    private lateinit var calendar: Calendar

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
//        return  DatePickerDialog(activity!!,2,this,year,month,day)
        return DatePickerDialog(activity!!,2,this, year, month, day)
       // return DatePickerDialog(activity, 2, this, year, month, day)
    }


    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        Toast.makeText(activity, "Date Set :${formatDate(year,month,day)}" ,Toast.LENGTH_SHORT).show()
        activity!!.findViewById<TextView>(R.id.text_bd).text=formatDate(year,month,day)
    }

    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity,"Please select a date.",Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }
    private fun formatDate(year: Int,month: Int,day: Int):String{
    calendar.set(year,month,day,0,0,0)
        val chosenDate = calendar.time
        val df = DateFormat.getDateInstance(DateFormat.SHORT)
        return df.format(chosenDate)
    }
}
package com.example.myapplication

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_table_info.*





class TableInfoActivity : AppCompatActivity() {

    var DIALOG_TIME = 1
    var myHour = 14
    var myMinute = 35
    var tvTime: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.reservedtables.R.layout.activity_table_info)
        tvTime = findViewById(com.example.reservedtables.R.id.tvTime)
        getinfo()
    }


    companion object {

        const val TOTAL_NUMBER = "total_count"

    }
    fun getinfo() {
        val number = intent.getStringExtra(TOTAL_NUMBER)
        table_number.text = "\n$number"
    }

    fun click(view: View)
    {
        showDialog(DIALOG_TIME)
    }

    override fun onCreateDialog(id: Int): Dialog {
        return if (id == DIALOG_TIME) {
            TimePickerDialog(this, myCallBack, myHour, myMinute, true)
        } else super.onCreateDialog(id)
    }

    var myCallBack: OnTimeSetListener = OnTimeSetListener { view, hourOfDay, minute ->
        myHour = hourOfDay
        myMinute = minute
        tvTime?.setText("$myHour : $myMinute")
    }


    fun reserve(view:View){

        if(name.getText().toString().equals("")||phone.getText().toString().equals("")
            ||tvTime?.getText().toString().equals(""))
        {
            val toast=Toast.makeText(this,"Для продолжения заполните все поля",Toast.LENGTH_SHORT)
            toast.show()
        }
        else
        {
            if(phone.getText().length!=11)
            {
                val toast=Toast.makeText(this,"Укажите номер телефона в формате 8ХХХХХХХХХХ",Toast.LENGTH_SHORT)
                toast.show()
                return
            }
            val toast=Toast.makeText(this,"Столик забронирован\n" +
                    "Ожидайте звонка в течении  минут",Toast.LENGTH_SHORT)
            toast.show()
            finish()
        }
    }

}

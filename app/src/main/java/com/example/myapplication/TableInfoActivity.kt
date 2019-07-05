package com.example.myapplication

import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.reservedtables.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_table_info.*

class TableInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_info)
        getinfo()
    }

    companion object {

        const val TOTAL_NUMBER = "total_count"

    }
    fun getinfo() {
        val number = intent.getStringExtra(TOTAL_NUMBER)
        table_number.text = "\n$number"
    }
    fun reserve(view:View){

        if(name.getText().toString().equals("")||phone.getText().toString().equals("")
            ||time.getText().toString().equals(""))
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

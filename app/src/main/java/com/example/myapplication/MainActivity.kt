package com.example.myapplication

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reservedtables.R

class MainActivity : AppCompatActivity() {

    val DIALOG_DATE:Int=1
    var myYear:Int = 2019
    var myMonth:Int = 6
    var myDay:Int = 6
    var tvDate: EditText? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvDate=findViewById(R.id.tvDate)
        val recyclerView: RecyclerView = findViewById(R.id.view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(generateFakeValues())
    }

    fun map(view: View) {
        val map = Intent(this, ReserveActivity::class.java)
        startActivity(map)
    }

    fun info(view: View) {
        val info = Intent(this, com.example.myapplication.TableInfoActivity::class.java)
        startActivity(info)
    }

    fun selectDate(view: View){
        val selectDate = Intent(this, com.example.myapplication.DateTimeActivity::class.java)
        startActivity(selectDate)
    }

    private fun generateFakeValues(): List<String>{  //добавление
        val values = mutableListOf<String>()
        for(i in 1..10) //8 столов
        {
            values.add("$i Стол")
        }
        return values
    }


    class Reserve (val id : Int, val busy: Boolean, val places: Int)
    fun getDate(view: View){
        showDialog(DIALOG_DATE)
    }

    override fun onCreateDialog(id: Int): Dialog {
        return if (id == DIALOG_DATE) {
            DatePickerDialog(this, myCallBack, myYear, myMonth, myDay)
        } else super.onCreateDialog(id)
    }
    var myCallBack: DatePickerDialog.OnDateSetListener =
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myYear = year
            myMonth = monthOfYear + 1
            myDay = dayOfMonth
            if (myMonth < 7||myDay<6||myYear<2019) {
                val toast = Toast.makeText(this, "Вы не можете выбрать эту дату", Toast.LENGTH_SHORT)
                toast.show()
                return@OnDateSetListener
            }
            tvDate?.setText("$myDay/$myMonth/$myYear")
        }
}


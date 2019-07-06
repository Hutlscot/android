package com.example.myapplication

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
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
        val str:String= (view as TextView)?.text.toString()
        val info = Intent(this, com.example.myapplication.TableInfoActivity::class.java)
        info.putExtra(com.example.myapplication.TableInfoActivity.TOTAL_NUMBER,str)
        startActivity(info)
    }

    fun Contact(view: View){
        val contact = Intent(this, com.example.myapplication.DateTimeActivity::class.java)
        startActivity(contact)
    }
    class  Reserve(var id:Int, val busy:String, var places:Int)
    val table = List(11) { Reserve(1, "cвободен", 4) }
    fun load(){
         table[0].id = 1
         table[1].id = 2
         table[2].id = 3
         table[3].id = 4
         table[3].places=2
         table[4].id = 5
         table[5].id = 6
         table[6].id = 7
         table[6].places=2
         table[7].id = 8
         table[7].places=6
         table[8].id = 9
         table[8].places=6
         table[9].id = 10
         table[9].places=8
         table[10].id = 11
         table[10].places=8

    }

    private fun generateFakeValues(): List<String>{  //добавление
        load()
        val values = mutableListOf<String>()
        for(i in 0..10) //8 столов
        {
            values.add(table[i].id.toString()+" cтол   ("+table[i].busy+")\nКол-во мест: "+table[i].places.toString())
        }
        return values
    }

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


package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reservedtables.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}

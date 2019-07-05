package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reservedtables.R
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

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

    private fun generateFakeValues(): List<String>{  //добавление
        val values = mutableListOf<String>()
        for(i in 1..10) //8 столов
        {
            values.add("$i Стол")
        }
        return values
    }


    class Table(val number: Int, val busy: String, val places: Int)
}

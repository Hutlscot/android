package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.reservedtables.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        }
    fun map(view: View) {
        val map = Intent(this, ReserveActivity::class.java)
        startActivity(map)
    }


    fun info(view: View) {
        val button = view as Button
        val info = Intent(this, com.example.myapplication.TableInfoActivity::class.java)
        val counttable= button.text.toString()
        info.putExtra(TableInfoActivity.TOTAL_NAMBER, counttable)
        startActivity(info)
    }
    }

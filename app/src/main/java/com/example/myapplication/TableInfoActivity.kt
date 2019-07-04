package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reservedtables.R
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
    fun getinfo(){
        val number=intent.getStringExtra(TOTAL_NUMBER)
        table_number.text="\n$number"
    }
}

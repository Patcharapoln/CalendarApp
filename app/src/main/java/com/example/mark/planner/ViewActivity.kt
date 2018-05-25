package com.example.mark.planner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import java.util.*
import android.view.LayoutInflater





class ViewActivity: AppCompatActivity() {

    private lateinit var input:EditText
    private var list: ListView? = null
    private lateinit var date:Date
    private var adapter1: ArrayAdapter<String>? = null
    private lateinit var event:ArrayList<String>
    private lateinit var presenter:PlannerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        input = findViewById<View>(R.id.input) as EditText
        list = findViewById<View>(R.id.list) as ListView?
        event = intent.getSerializableExtra("event") as ArrayList<String>
        date = intent.getSerializableExtra("date") as Date
        adapter1 = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, event)
        presenter = PlannerPresenter()
        list!!.adapter = adapter1
        adapter1!!.notifyDataSetChanged()
    }

    fun handleRemove(view: View){
        event = presenter.remove(event,input.text.toString())
        adapter1!!.notifyDataSetChanged()
    }
}
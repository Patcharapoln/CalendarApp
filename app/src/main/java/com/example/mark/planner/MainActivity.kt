package com.example.mark.planner

import android.graphics.Color
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.domain.Event

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private var calendar: CompactCalendarView? = null
    private lateinit var input: EditText
    private var day: Long = 0
    private var date : Date? = null
    private lateinit var actionBar: ActionBar
    private lateinit var presenter : CalendarPresenter
    private lateinit var list:ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        input = findViewById<View>(R.id.input) as EditText
        button = findViewById<View>(R.id.button) as Button
        actionBar = this!!.supportActionBar!!
        calendar = findViewById<View>(R.id.calendar) as CompactCalendarView
        presenter = CalendarPresenter(calendar!!)
        list = ArrayList<String>()
        val formatDay = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
        actionBar.title = formatDay.format(calendar!!.firstDayOfCurrentMonth)
        calendar!!.setListener(object : CompactCalendarView.CompactCalendarViewListener {

            override fun onDayClick(dateClicked: Date) {
                date = dateClicked
                day = dateClicked.time
                println(day)
            }

            override fun onMonthScroll(firstDayOfNewMonth: Date) {
                val formatDay = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
                actionBar.title = formatDay.format(firstDayOfNewMonth)
            }
        })
        presenter.initializeCalendar()
    }

    fun handlePress(v: View) {
        if (input == null) input.hint = "Input field is empty!!"
        var e = Event(Color.RED,day,input.text.toString())
        presenter.addEvent(e)
    }

    fun handleView(v: View){
        val intent = Intent(this, ViewActivity::class.java)
        list.clear()
        for(e in this.getEvent()){
            list.add(e.data as String)
        }
        intent.putExtra("event",list)
        intent.putExtra("date",date)
        startActivity(intent)
    }

    fun getEvent(): List<Event> {
        return presenter.getEvent(this.date!!)
    }

}

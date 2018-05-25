package com.example.mark.planner

import android.graphics.Color
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.domain.Event
import java.util.*

/**
 * Created by mark on 24/5/2018 AD.
 */
class CalendarPresenter (val calendarView: CompactCalendarView){
    val calendar = Calendar(calendarView)
    fun addEvent(e: Event){
        if(e!= null)
            calendar.getCalendar().addEvent(e)
    }

    fun getEvent(date: Date): List<Event> {
        return calendar.getEvent(date)
    }

    fun initializeCalendar(){
        calendar.getCalendar().addEvent(Event(Color.GREEN,1525132800000,"Worker day"))
        calendar.getCalendar().addEvent(Event(Color.GREEN,1523577600000,"Songkran day"))
        calendar.getCalendar().addEvent(Event(Color.GREEN,1523664000000,"Songkran day"))
        calendar.getCalendar().addEvent(Event(Color.GREEN,1523750400000,"Songkran day"))
        calendar.getCalendar().addEvent(Event(Color.GREEN,1527552000000,"Visakabucha day"))
    }
}
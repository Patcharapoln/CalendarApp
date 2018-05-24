package com.example.mark.planner

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

}
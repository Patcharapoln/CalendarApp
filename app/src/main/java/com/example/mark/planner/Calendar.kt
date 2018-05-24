package com.example.mark.planner

import android.graphics.Color
import com.example.mark.planner.R.id.input
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.domain.Event
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by mark on 24/5/2018 AD.
 */
class Calendar (val c: CompactCalendarView) {

    private var calendar = c
    private var event = ArrayList<Event>()
    fun getCalendar(): CompactCalendarView {
        return calendar
    }

    fun getEvent(date: Date): List<Event> {
        return calendar.getEvents(date)
    }
}
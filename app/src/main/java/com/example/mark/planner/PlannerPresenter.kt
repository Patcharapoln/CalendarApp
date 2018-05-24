package com.example.mark.planner

import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.domain.Event
import java.util.*

/**
 * Created by mark on 24/5/2018 AD.
 */
class PlannerPresenter() {

    private var elist = ArrayList<Event>()

    fun remove (event:ArrayList<String>,input :String): ArrayList<String> {
        for(e in event){
            if(e.equals(input))
            event.remove(e)
        }
        return event
    }
}
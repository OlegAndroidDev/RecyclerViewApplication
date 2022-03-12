package com.example.recyclerviewapp

import com.example.recyclerviewapp.model.Event

object EventSingleton {
    var event = mutableListOf<Event>()
    fun addEvent(event: Event) {
        EventSingleton.event.add(event)
    }
    init {}
}
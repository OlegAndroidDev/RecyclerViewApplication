package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.model.Event

class EventAdapter(
    private val eventList: MutableList<Event> = mutableListOf()

): RecyclerView.Adapter<EventViewHolder>() {

    private lateinit var mListener: OnEventClickListener

    interface OnEventClickListener{
        fun onEventClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnEventClickListener) {
        mListener = listener
    }


    fun updateEventData(events: MutableList<Event>) {
        eventList.clear()
        eventList.addAll(events)
        notifyDataSetChanged()
    }

//    fun updateEventData(event: Event){
//        eventList.add(0, event)
//        notifyItemInserted(eventList.indexOf(event))
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(eventView, mListener)
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
//
//        //inflating event from XML file
//        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_item,parent,false)
//        return EventViewHolder(eventView)
//    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = eventList.size
}

//class EventViewHolder(itemView: View, listener: EventAdapter.OnEventClickListener): RecyclerView.ViewHolder(itemView){
//    private val title: TextView = itemView.findViewById(R.id.event_title)
//    private val category: TextView = itemView.findViewById(R.id.event_category)
//    private val date: TextView = itemView.findViewById(R.id.event_date)
//
//    fun bind(event: Event){
//        title.text = event.title
//        category.text = event.category
//        date.text = event.date
//    }
//}

class EventViewHolder(itemView: View, listener: EventAdapter.OnEventClickListener) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.event_title)
    private val category: TextView = itemView.findViewById(R.id.event_category)
    private val date: TextView = itemView.findViewById(R.id.event_date)

    init {
        itemView.setOnClickListener {
            listener.onEventClick(adapterPosition)
        }
    }

    fun bind(event: Event) {
        title.text = event.title
        category.text = event.category
        date.text = event.date
    }
}
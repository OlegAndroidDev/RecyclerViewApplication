package com.example.recyclerviewapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.Toast
import com.example.recyclerviewapp.EventSingleton
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.adapter.EventAdapter
import com.example.recyclerviewapp.databinding.FragmentSecondBinding
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }
    private val eventAdapter by lazy{
        EventAdapter()
    }
    private var counter = 0

    private lateinit var title: String
    private lateinit var category: String

    val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    private var formattedDate = (LocalDate.now()).format(formatter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.cnlBtn.setOnClickListener(){
            fragmentNavigation(supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFragment.newInstance("", ""))
        }

        binding.eventCalendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            formattedDate = "${month + 1}/$dayOfMonth/$year"
        }

        binding.doneBtn.setOnClickListener {
            if (binding.eventTitleEt.text.isNotEmpty() && binding.eventCategoryEt.text.isNotEmpty()) {
                title = binding.eventTitleEt.text.toString()
                category = binding.eventCategoryEt.text.toString()
                //stringDate = binding.eventCalendar.date.toString()

                EventSingleton.addEvent(Event(title, category, formattedDate))
                fragmentNavigation(
                    supportFragmentManager = requireActivity().supportFragmentManager,
                    FirstFragment.newInstance("", ""))
            }
            else {
                Toast.makeText(requireContext(), R.string.fields_required, Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        date = if (formattedDate.isNotEmpty()) {
//            sdf.parse(formattedDate).time
//        } else {
//            binding.eventCalendar.date
//        }
//        outState.putLong("date", date)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val tempDate: Long
//        if (savedInstanceState!= null) {
//            tempDate = savedInstanceState?.getLong("date")
//            binding.eventCalendar.date = tempDate
//            formattedDate = sdf.format(tempDate)
//        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
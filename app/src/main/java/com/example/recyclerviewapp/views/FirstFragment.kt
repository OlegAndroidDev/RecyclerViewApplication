package com.example.recyclerviewapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewapp.EventSingleton
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.adapter.EventAdapter
import com.example.recyclerviewapp.databinding.FragmentFirstBinding
import com.example.recyclerviewapp.fragmentNavigation
import com.example.recyclerviewapp.model.Event

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy{
        FragmentFirstBinding.inflate(layoutInflater)
    }

    private var counter = 0

    //Adapter
    private val eventAdapter by lazy{
        EventAdapter()
    }

    private val bundle by lazy {
        Bundle()
    }


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

        binding.myRecycler.apply{
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = eventAdapter

//            binding.dropdownList.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                    val selectedItem = p0?.getItemAtPosition(p2).toString()
//                    val stringArray = resources.getStringArray(R.array.taskOrdered)
//                    if (selectedItem.equals(stringArray[0])) {
//                        val ascending = EventSingleton.event.sortBy {
//                            it.date
//                        }
//                    }
//                    else {
//                        var descending = EventSingleton.event.sortByDescending {
//                            it.date
//                        }
//                    }
//                }
//                override fun onNothingSelected(p0: AdapterView<*>?) {
//                    TODO("Not yet implemented")
//                }
//            }
        }
//        EventSingleton.event.forEach { item ->
//            eventAdapter.updateEventData(item)
//        }
        eventAdapter.updateEventData(EventSingleton.event)

        binding.addEvent.setOnClickListener {
            fragmentNavigation(
                supportFragmentManager = requireActivity().supportFragmentManager,
                SecondFragment.newInstance("", "")
            )
        }

        eventAdapter.setOnItemClickListener(object: EventAdapter.OnEventClickListener{
            override fun onEventClick(position: Int) {
                bundle.putInt("position", position)
                fragmentNavigation(supportFragmentManager = requireActivity().supportFragmentManager, ThirdFragment.newInstance(position))
            }
        })

            return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
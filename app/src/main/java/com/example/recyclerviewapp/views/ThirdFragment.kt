package com.example.recyclerviewapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewapp.EventSingleton
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.databinding.FragmentThirdBinding
import com.example.recyclerviewapp.fragmentNavigation
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }
    private var position by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = this.arguments

        if (bundle != null) {
            position = bundle.getInt("position")
        }
        binding.eventTitleText.setText(EventSingleton.event[position].title)
        binding.eventCategoryText.setText(EventSingleton.event[position].category)
        binding.eventDate.setText(EventSingleton.event[position].date)
        binding.closeBtn.setOnClickListener(){
            fragmentNavigation(supportFragmentManager = requireActivity().supportFragmentManager,
                FirstFragment.newInstance("", ""))
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        @JvmStatic
        fun newInstance(position: Int) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putInt("position", position)
                }
            }
    }
}
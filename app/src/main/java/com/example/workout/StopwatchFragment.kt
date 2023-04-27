package com.example.workout

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [StopwatchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StopwatchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var wasRunning: Boolean = false
    private var running: Boolean = false
    private var second: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            wasRunning = it.getBoolean(ARG_PARAM1)
            running = it.getBoolean(ARG_PARAM2)
        }
        savedInstanceState?.let {
            wasRunning = it.getBoolean(ARG_PARAM1)
            running = it.getBoolean(ARG_PARAM2)
            second = it.getInt(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_stopwatch, container, false)
        runTimer(layout)
        layout.findViewById<Button>(R.id.start).setOnClickListener {
            running = true
        }
        layout.findViewById<Button>(R.id.stop).setOnClickListener {
            running = false
        }
        layout.findViewById<Button>(R.id.reset).setOnClickListener {
            running = false
            second = 0
        }
        return layout
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        running = wasRunning
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(ARG_PARAM1, wasRunning)
        outState.putBoolean(ARG_PARAM2, running)
        outState.putInt(ARG_PARAM3, second)
    }

    private fun runTimer(view: View) {
        val time = view.findViewById<TextView>(R.id.time)
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val hours = second / 3600
                val minutes = (second % 3600) / 60
                val secs = second % 60
                val timeText =
                    String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, secs)
                time?.apply { text = timeText }
                if (running) second++
                handler.postDelayed(this, 1000)
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StopwatchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Boolean, param2: Boolean) =
            StopwatchFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_PARAM1, param1)
                    putBoolean(ARG_PARAM2, param2)
                }
            }
    }
}
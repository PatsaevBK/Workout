package com.example.workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.workout.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity(), WorkoutListFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun itemClicked(id: Long) {
        val fragmentContainer= findViewById<View>(R.id.fragment_container)
        if (fragmentContainer != null) {
            val details: WorkoutDetailFragment = WorkoutDetailFragment()
            val transaction = supportFragmentManager.beginTransaction()
            details.workoutID = id
            transaction.replace(R.id.fragment_container, details)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction.addToBackStack(null)
            transaction.commit()
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, id)
            startActivity(intent)

        }
    }
}
package com.example.workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag = supportFragmentManager.findFragmentById(R.id.detail_frag) as? WorkoutDetailFragment
        frag?.let {
            it.workoutID = intent.getLongExtra(EXTRA_WORKOUT_ID, -1)
        }
    }

    companion object {
        const val EXTRA_WORKOUT_ID = "ID"
    }
}
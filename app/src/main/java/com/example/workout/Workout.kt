package com.example.workout

data class Workout(
    val name: String,
    val description: String
) {
    companion object {
        val workouts = mutableListOf<Workout>(
            Workout(
                "The Limb Looser", """5 Handstand push-ups
                |10 1-legged squats
                |15 Pull-ups
            """.trimMargin()
            ),
            Workout(
                "Core Agony",
                """100 Pull-ups
                    |100 Sit-ups
                    |100 Squats
                """.trimMargin()
            ),
            Workout(
                "Strength and Length",
                """500 meter run
                    |21 x 1.5 pood kettleball swing
                    |21 x pull-ups
                """.trimMargin()
            )
        )
    }
}

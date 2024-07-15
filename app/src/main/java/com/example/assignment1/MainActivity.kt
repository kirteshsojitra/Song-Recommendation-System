package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var moodSpinner: Spinner
    private lateinit var genreSpinner: Spinner
    private lateinit var recommendButton: Button
    private lateinit var recommendedSongTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moodSpinner = findViewById(R.id.mood_spinner)
        genreSpinner = findViewById(R.id.genre_spinner)
        recommendButton = findViewById(R.id.recommend_button)
        recommendedSongTextView = findViewById(R.id.recommended_song_textview)

        val moodOptions = arrayOf("Happy", "Sad", "Relaxed", "Energetic")
        val genreOptions = arrayOf("Pop", "Rock", "Hip-Hop", "Classical")

        val moodAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, moodOptions)
        val genreAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genreOptions)

        moodSpinner.adapter = moodAdapter
        genreSpinner.adapter = genreAdapter

        recommendButton.setOnClickListener {
            val mood = moodSpinner.selectedItem.toString()
            val genre = genreSpinner.selectedItem.toString()
            val recommendedSong = getRecommendedSong(mood, genre)
            recommendedSongTextView.text = "Recommended song: $recommendedSong"
        }

        moodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Handle mood spinner selection
                val mood = moodSpinner.selectedItem.toString()
                recommendedSongTextView.text = "You selected $mood mood"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle no selection
                recommendedSongTextView.text = "Please select a mood"
            }
        }

        genreSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Handle genre spinner selection
                val genre = genreSpinner.selectedItem.toString()
                recommendedSongTextView.text = "You selected $genre genre"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle no selection
                recommendedSongTextView.text = "Please select a genre"
            }
        }
    }

    private fun getRecommendedSong(mood: String, genre: String): String {
        // Implement song recommendation logic here
        when (mood) {
            "Happy" -> {
                when (genre) {
                    "Pop" -> return "Walking on Sunshine"
                    "Rock" -> return "I Gotta Feeling"
                    "Hip-Hop" -> return "Happy"
                    "Classical" -> return "Ode to Joy"
                }
            }
            "Sad" -> {
                when (genre) {
                    "Pop" -> return "Someone Like You"
                    "Rock" -> return "Tears in Heaven"
                    "Hip-Hop" -> return "Lose Yourself"
                    "Classical" -> return "Moonlight Sonata"
                }
            }
            "Relaxed" -> {
                when (genre) {
                    "Pop" -> return "Island in the Sun"
                    "Rock" -> return "Hotel California"
                    "Hip-Hop" -> return "Regulate"
                    "Classical" -> return "Clair de Lune"
                }
            }
            "Energetic" -> {
                when (genre) {
                    "Pop" -> return "Uptown Funk"
                    "Rock" -> return "Eye of the Tiger"
                    "Hip-Hop" -> return "Lose Yourself"
                    "Classical" -> return "William Tell Overture"
                }
            }
        }
        return "No recommendation found"
    }
}
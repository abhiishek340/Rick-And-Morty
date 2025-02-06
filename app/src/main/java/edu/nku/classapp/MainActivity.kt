package edu.nku.classapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.nku.classapp.data.model.Location
import edu.nku.classapp.databinding.ActivityMainBinding
import androidx.core.widget.addTextChangedListener
import kotlin.random.Random
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val characters = mutableListOf<RickAndMortyCharacter>()
    private val searchAdapter = RickAndMortyCharacterAdapter(mutableListOf())
    private val mainAdapter = RickAndMortyCharacterAdapter(characters)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Create multiple test characters
            val testCharacters = (1..10).map { id ->
                createCharacter(id)
            }

            // Set up RecyclerView with characters and click handling
            binding.searchResultsRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = RickAndMortyCharacterAdapter(testCharacters) { character ->
                    Toast.makeText(
                        this@MainActivity,
                        "Clicked: ${character.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun createCharacter(id: Int) = RickAndMortyCharacter(
        id = id,
        name = "${names.random()} ${lastNames.random()}",
        status = listOf("Alive", "Dead", "Unknown").random(),
        species = listOf("Human", "Alien", "Robot", "Unknown").random(),
        type = "",
        gender = listOf("Male", "Female", "Unknown").random(),
        origin = edu.nku.classapp.data.model.Location(id, planets.random(), ""),
        location = edu.nku.classapp.data.model.Location(id, planets.random(), ""),
        image = "https://rickandmortyapi.com/api/character/avatar/$id.jpeg",
        episode = listOf(),
        url = "",
        created = "",
        isFavorite = false
    )

    companion object {
        private val names = listOf("Rick", "Morty", "Summer", "Beth", "Jerry")
        private val lastNames = listOf("Sanchez", "Smith", "Thompson", "Johnson")
        private val planets = listOf("Earth", "Mars", "Jupiter", "Saturn", "Neptune")
    }
}
package edu.nku.classapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import edu.nku.classapp.databinding.ItemCharacterBinding
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.widget.TextView
import com.google.android.material.chip.Chip
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import android.view.View

class RickAndMortyCharacterAdapter(
    private var characters: List<RickAndMortyCharacter>,
    private val onCharacterClick: (RickAndMortyCharacter) -> Unit = {}
) : RecyclerView.Adapter<RickAndMortyCharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size

    fun updateCharacters(newCharacters: List<RickAndMortyCharacter>) {
        characters = newCharacters
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    try {
                        val character = characters[position]
                        Toast.makeText(
                            binding.root.context,
                            "Opening details for ${character.name}",
                            Toast.LENGTH_SHORT
                        ).show()
                        showCharacterDetails(character)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Toast.makeText(
                            binding.root.context,
                            "Error: ${e.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }

        private fun showCharacterDetails(character: RickAndMortyCharacter) {
            val context = binding.root.context
            
            try {
                // Inflate the dialog layout
                val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_character_details, null)
                
                // Create and show the dialog
                val dialog = MaterialAlertDialogBuilder(context)
                    .setView(dialogView)
                    .create()

                // Find views in the inflated layout
                val characterImage = dialogView.findViewById<ShapeableImageView>(R.id.characterImage)
                val characterName = dialogView.findViewById<TextView>(R.id.characterName)
                val statusChip = dialogView.findViewById<TextView>(R.id.statusChip)
                val speciesChip = dialogView.findViewById<TextView>(R.id.speciesChip)
                val genderChip = dialogView.findViewById<TextView>(R.id.genderChip)
                val funFactsText = dialogView.findViewById<TextView>(R.id.funFactsText)
                val closeButton = dialogView.findViewById<MaterialButton>(R.id.closeButton)

                // Set character image
                characterImage?.load(character.image) {
                    crossfade(true)
                    placeholder(R.drawable.ic_placeholder)
                    error(R.drawable.ic_error)
                }

                // Set character name
                characterName?.text = character.name

                // Set status background color
                statusChip?.apply {
                    text = character.status
                    setBackgroundResource(
                        when (character.status.lowercase()) {
                            "alive" -> R.color.status_alive
                            "dead" -> R.color.status_dead
                            else -> R.color.status_unknown
                        }
                    )
                }

                // Set other chips
                speciesChip?.text = character.species
                genderChip?.text = character.gender

                // Set fun facts
                val funFacts = buildString {
                    appendLine("• Origin: ${character.origin.name}")
                    appendLine("• Current Location: ${character.location.name}")
                    appendLine("• Number of Episodes: ${character.episode.size}")
                    appendLine("• Species: ${character.species}")
                    if (character.type.isNotEmpty()) {
                        appendLine("• Type: ${character.type}")
                    }
                    appendLine("• Status: ${character.status}")
                }
                funFactsText?.text = funFacts

                // Set close button click listener
                closeButton?.setOnClickListener {
                    dialog.dismiss()
                }

                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                dialog.show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(context, "Error showing details: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        fun bind(character: RickAndMortyCharacter) {
            binding.apply {
                characterName.text = character.name
                statusChip.text = character.status
                statusChip.setChipBackgroundColorResource(
                    when (character.status.lowercase()) {
                        "alive" -> R.color.status_alive
                        "dead" -> R.color.status_dead
                        else -> R.color.status_unknown
                    }
                )
                speciesChip.text = character.species
                locationText.text = character.location.name
                genderText.text = character.gender
                characterImage.load(character.image) {
                    crossfade(true)
                    placeholder(R.drawable.ic_placeholder)
                    error(R.drawable.ic_error)
                    transformations(CircleCropTransformation())
                }
            }
        }
    }
}
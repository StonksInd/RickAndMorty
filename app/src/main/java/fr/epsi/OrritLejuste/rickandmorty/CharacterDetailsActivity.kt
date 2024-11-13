package fr.epsi.OrritLejuste.rickandmorty

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import android.widget.ImageView
import android.widget.TextView

class CharacterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val character = intent.getParcelableExtra<Character>("character")
        if (character == null) {
            Log.e("CharacterDetailsActivity", "Character is null")
            finish() // Ferme l'activité si aucun personnage n'est trouvé
        }

        val imageView: ImageView = findViewById(R.id.character_detail_image)
        val nameTextView: TextView = findViewById(R.id.character_detail_name)
        val statusTextView: TextView = findViewById(R.id.character_detail_status)
        val speciesTextView: TextView = findViewById(R.id.character_detail_species)
        val originTextView: TextView = findViewById(R.id.character_detail_origin)

        character?.let {
            nameTextView.text = it.name
            statusTextView.text = it.status
            speciesTextView.text = it.species
            originTextView.text = it.origin
            imageView.load(it.imageUrl)


            if (it.imageUrl.isEmpty()) {
                Log.e("CharacterDetailsActivity", "Image URL is empty")
            }
        }
    }
}

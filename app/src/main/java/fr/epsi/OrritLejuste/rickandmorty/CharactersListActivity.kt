package fr.epsi.OrritLejuste.rickandmorty

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        Log.d("CharactersListActivity", "onCreate called")


        val characters = loadCharacters()


        val recyclerView: RecyclerView = findViewById(R.id.characters_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CharacterAdapter(characters) { character ->
            val intent = Intent(this, CharacterDetailsActivity::class.java)
            intent.putExtra("character", character)
            startActivity(intent)
        }
    }

    private fun loadCharacters(): List<Character> {
        val charactersList = mutableListOf<Character>()
        val resources = resources
        val packageName = packageName

        // Boucle sur les numéros de personnage (ici on suppose un maximum de 10)
        for (i in 1..10) {
            val nameId = resources.getIdentifier("character_${i}_name", "string", packageName)
            val statusId = resources.getIdentifier("character_${i}_status", "string", packageName)
            val speciesId = resources.getIdentifier("character_${i}_species", "string", packageName)
            val originId = resources.getIdentifier("character_${i}_origin", "string", packageName)
            val imageId = resources.getIdentifier("character_${i}_image", "string", packageName)


            if (nameId != 0 && statusId != 0 && speciesId != 0 && originId != 0 && imageId != 0) {
                val character = Character(
                    resources.getString(nameId),
                    resources.getString(statusId),
                    resources.getString(speciesId),
                    resources.getString(originId),
                    resources.getString(imageId)
                )
                charactersList.add(character)
            }
        }
        return charactersList
    }
}

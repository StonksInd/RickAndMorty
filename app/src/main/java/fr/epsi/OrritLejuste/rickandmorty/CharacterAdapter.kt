package fr.epsi.OrritLejuste.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class CharacterAdapter(
    private val characters: List<Character>,
    private val onItemClick: (Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val characterImage: ImageView = view.findViewById(R.id.character_image)
        val characterName: TextView = view.findViewById(R.id.character_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.characterName.text = character.name
        holder.characterImage.load(character.imageUrl)
        holder.itemView.setOnClickListener { onItemClick(character) }
    }

    override fun getItemCount(): Int = characters.size
}

package fr.epsi.OrritLejuste.rickandmorty

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val status: String,
    val species: String,
    val origin: String,
    val imageUrl: String
) : Parcelable

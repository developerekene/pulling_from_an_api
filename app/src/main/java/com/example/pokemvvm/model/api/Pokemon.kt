package com.example.pokemvvm.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon (
    //@Expose used to mark a field to be exposed or not (included or not) for serialized or deserialized
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("weight") val weight: Int,
    @Expose @SerializedName("height") val height: Int,
    @Expose @SerializedName("sprites") val sprites: Sprites
    )

data class Sprites (
    //@Expose used to mark a field to be exposed or not (included or not) for serialized or deserialized
    @Expose @SerializedName("front_default") val frontDefault: String?,
    @Expose @SerializedName("front_shiny") val frontShiny: String?
)
package br.edut.utfpr.quote.models

import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    val id: Int,
    val quote: String,
    val author: String,
)

package br.edut.utfpr

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
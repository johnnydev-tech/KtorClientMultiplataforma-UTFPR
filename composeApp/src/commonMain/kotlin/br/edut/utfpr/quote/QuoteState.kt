package br.edut.utfpr.quote

sealed class QuoteState {
    data object Loading : QuoteState()
    data class Success(val quote: Quote) : QuoteState()
    data class Error(val message: String) : QuoteState()
}
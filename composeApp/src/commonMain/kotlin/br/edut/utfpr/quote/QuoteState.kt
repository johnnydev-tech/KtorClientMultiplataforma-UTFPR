package br.edut.utfpr.quote

import br.edut.utfpr.quote.models.Quote

sealed class QuoteState {
    data object Loading : QuoteState()
    data class Success(val quote: Quote) : QuoteState()
    data class Error(val message: String) : QuoteState()
}
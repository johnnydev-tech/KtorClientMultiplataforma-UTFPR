package br.edut.utfpr

import QuoteServiceKtor
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import br.edut.utfpr.quote.QuoteScreen
import br.edut.utfpr.quote.QuoteState

import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var state by remember { mutableStateOf<QuoteState>(QuoteState.Loading) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            try {
                val quotesK = QuoteServiceKtor()
                val quote = quotesK.getRandomQuote()

                state = QuoteState.Success(quote)

            } catch (e: Exception) {
                state = QuoteState.Error("Failed to load quote: ${e.message}")
            }
        }
    }
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF5F5F5)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AnimatedVisibility(visible = state is QuoteState.Loading) {
                    CircularProgressIndicator()
                }
                AnimatedVisibility(visible = state is QuoteState.Success) {
                    state.let { quoteState ->
                        if (quoteState is QuoteState.Success) {
                            QuoteScreen(quote = quoteState.quote)
                        }
                    }
                }
                AnimatedVisibility(visible = state is QuoteState.Error) {
                    Text(text = (state as QuoteState.Error).message)
                }
            }
        }
    }
}
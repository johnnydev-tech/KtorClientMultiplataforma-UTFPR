package br.edut.utfpr.quote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edut.utfpr.quote.data.MockQuote
import br.edut.utfpr.quote.models.Quote
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun QuoteScreen(quote: Quote) {
    QuoteItem(quote = quote)
}

@Composable
@Preview
private fun QuoteScreenPreview() {
    val sampleQuote = Quote(
        id = 1,
        quote = "The only limit to our realization of tomorrow is our doubts of today.",
        author = "Franklin D. Roosevelt",
    )
    QuoteScreen(quote = sampleQuote)
}


@Composable
fun QuoteItem(
    quote: Quote,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFDFDFD)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "“${quote.quote}”",
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "- ${quote.author}",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${quote.id}",
                fontSize = 14.sp,
                color = Color.DarkGray
            )

        }
    }
}

@Preview()
@Composable
private fun QuoteItemPreview() {
    QuoteItem(quote = MockQuote.sampleQuote)
}
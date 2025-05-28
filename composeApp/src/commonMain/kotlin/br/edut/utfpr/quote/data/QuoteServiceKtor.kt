import br.edut.utfpr.quote.models.Quote
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class QuoteServiceKtor {

    private val client by lazy {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }

    suspend fun getRandomQuote(): Quote {
        val response = client.get("https://dummyjson.com/quotes/random") {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
            }
        }
        if (response.status.value == 200) {
            return response.body()
        } else {
            throw Exception("Failed to fetch quote: ${response.status.value}")
        }
    }
}
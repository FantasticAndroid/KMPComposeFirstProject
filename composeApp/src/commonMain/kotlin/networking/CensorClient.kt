package networking

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import networking.model.CensorResponse
import networking.util.IError
import networking.util.NetworkError
import networking.util.Result

class CensorClient(private val httpClient: HttpClient) {

    suspend fun censorWords(uncensored : String) : Result<String, IError> {
        val response = try {
            httpClient.get(urlString = CENSOR_URL){
                parameter("text", uncensored)
            }
        } catch(e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch(e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION_ERROR)
        }

        return when(response.status.value) {
            in 200..299 -> Result.Success(response.body<CensorResponse>().result)
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            409 -> Result.Error(NetworkError.CONFLICT)
            408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
            413 -> Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN_ERROR)
        }
    }
}
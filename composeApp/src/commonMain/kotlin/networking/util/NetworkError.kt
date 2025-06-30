package networking.util

enum class NetworkError : IError {
    REQUEST_TIMEOUT,
    UNAUTHORIZED,
    CONFLICT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    PAYLOAD_TOO_LARGE,
    SERIALIZATION_ERROR,
    UNKNOWN_ERROR
}
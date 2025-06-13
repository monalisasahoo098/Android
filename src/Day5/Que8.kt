package Day5

fun main() {
    try {
        println(login("mona", "mona"))
    } catch (e: LoginFailedException) {
        println("Error: ${e.message}")
    }
}
class LoginFailedException(message: String) : Exception(message)
@Throws(LoginFailedException::class)
fun login(username: String, password: String): String {
    if (username != "mona" || password != "123") {
        throw LoginFailedException("Login failed for user '$username'")
    }
    return "Welcome, dear $username!"
}



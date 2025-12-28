//Otpservice.kt
package lancorC.auth

import java.time.Instant
import java.util.concurrent.ConcurrentHashMap
import kotlin.random.Random

object OtpService {

    private data class OtpEntry(
        val otp: String,
        val expiresAt: Instant
    )

    private val store = ConcurrentHashMap<String, OtpEntry>()

    fun generateOtp(email: String): String {
        val otp = Random.nextInt(100000, 999999).toString()
        store[email] = OtpEntry(
            otp = otp,
            expiresAt = Instant.now().plusSeconds(300) // 5 minutes
        )
        println("OTP for $email is $otp") // TEMP (for testing)
        return otp
    }

    fun verifyOtp(email: String, otp: String): Boolean {
        val entry = store[email] ?: return false
        if (Instant.now().isAfter(entry.expiresAt)) {
            store.remove(email)
            return false
        }
        val valid = entry.otp == otp
        if (valid) store.remove(email)
        return valid
    }
}
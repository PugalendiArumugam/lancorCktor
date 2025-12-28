package lancorC.auth

object EmailService {

    fun sendOtp(email: String, otp: String) {
        // TEMP: replace later with SMTP / SendGrid
        println("📧 Sending OTP [$otp] to $email")
    }
}

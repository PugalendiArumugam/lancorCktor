//AuthRoutes.kt
package lancorC.auth


import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authRoutes() {

    route("/auth") {

        post("/request-otp") {

            val request = call.receive<OtpRequest>()

            // 1️⃣ Generate OTP
            val otp = OtpService.generateOtp(request.email)

            // 2️⃣ SEND EMAIL — THIS IS THE CORRECT PLACE
            EmailService.sendOtp(
                email = request.email,
                otp = otp
            )

            // 3️⃣ Respond to client
            call.respond(
                AuthResponse(
                    success = true,
                    message = "OTP sent to email"
                )
            )
        }

        post("/verify-otp") {
            val request = call.receive<OtpVerifyRequest>()
            val isValid = OtpService.verifyOtp(request.email, request.otp)

            call.respond(
                AuthResponse(
                    success = isValid,
                    message = if (isValid) "Login successful" else "Invalid OTP"
                )
            )
        }
    }
}

package bts.chat.com.plugins

import bts.chat.com.auth.model.User
import bts.chat.com.db.datastore.dao.UserEntity
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import java.util.*
const val secret = "aVerySecretKey"
const val issuer = "demos.inassar.me"
const val audience = "bts_chats"
const val mRealm = "Access to 'bts chats'"

fun Application.configureSecurity() {
    // Please read the jwt property from the config file if you are using EngineMain
    val jwtAudience = audience
    val jwtDomain = "https://jwt-provider-domain/"
    val jwtRealm = mRealm
    val jwtSecret = secret
    authentication {
        jwt {
            realm = jwtRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(jwtSecret))
                    .withAudience(jwtAudience)
                    .withIssuer(jwtDomain)
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(jwtAudience)) JWTPrincipal(credential.payload) else null
            }
        }
    }
}


fun generateToken( user: UserEntity): String {
    val maxHours = 3_600_000 * 24 // 24h
    val expiresAt = Date(System.currentTimeMillis() + maxHours)
    val claims =
        hashMapOf("email" to user.email, "password" to user.password)

    return JWT.create()
        .withAudience(audience)
        .withIssuer(issuer)
        .withClaim("data", claims)
        .withExpiresAt(expiresAt)
        .sign(Algorithm.HMAC256(secret))
}
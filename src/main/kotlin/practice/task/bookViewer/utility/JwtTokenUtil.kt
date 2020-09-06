package practice.task.bookViewer.utility

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import practice.task.bookViewer.db.Author
import practice.task.bookViewer.db.AuthorRepository
import java.util.*
import java.util.function.Function

object JwtTokenUtil {
    private var secret = "supersecret"
    private var JWT_TOKEN_VALIDITY = 5 * 60 * 60.toLong()

    private fun getUsernameFromToken(token: String?): String {
        return getClaimFromToken(token, Function { obj: Claims -> obj.subject })
    }

    private fun getExpirationDateFromToken(token: String?): Date {
        return getClaimFromToken(token, Function { obj: Claims -> obj.expiration })
    }

    private fun <T> getClaimFromToken(token: String?, claimsResolver: Function<Claims, T>): T {
        val claims = getAllClaimsFromToken(token)
        return claimsResolver.apply(claims)
    }

    private fun getAllClaimsFromToken(token: String?): Claims {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
    }

    private fun isTokenExpired(token: String?): Boolean {
        val expiration = getExpirationDateFromToken(token)
        return expiration.before(Date())
    }

    fun generateToken(username: String): String {
        return Jwts.builder().setSubject(username).setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact()
    }

    fun validateToken(token: String?, authorRepository: AuthorRepository): Author? {
        if (token != null) {
            val usernameToken = getUsernameFromToken(token)
            var author = authorRepository.findByUsername((usernameToken))
            if (!isTokenExpired(token) && author != null)
                return author
        }
        return null
    }
}
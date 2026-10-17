package in.sp.main.service;


import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	private String secretKey="";
	public JWTService() {
		try {
			KeyGenerator keyGen=KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk=keyGen.generateKey();
			secretKey=Base64.getEncoder().encodeToString(sk.getEncoded());//converts SecretKey type to String
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	public String generateToken(String username) {
		Map<String,Object> claims=new HashMap();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()*60*60*30))
				.and()
				.signWith(getKey())
				.compact();
				
		//return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Ik1hbmR5IiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.n40DvE9efh4UV8cyCCYT-CrHYYkHsBdRIrH4LMdFRW8";
	}

	private Key getKey() {
		//to convert string to bytes bcoz hmacShaKeyFor reuires secretKey to be in bytes
		byte[] keyBytes=Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
//.signWith(getKey()) This is extremely important for JWT security.Remember your JWT has:HEADER.PAYLOAD.SIGNATURE The signature is created using your secret key. So:getKey() gets the secret key.
//And-"I'm done configuring the claims. Go back to the JWT builder."
//The subject (sub) is normally used to identify who the token belongs to.
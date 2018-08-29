package xyz.michaeljohnson.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

@Configuration
public class AuthConfig {

	
//	
//	private final KeyStoreKeyFactory keystore;
//	
////	private final KeyPair keypair;
//	
//	public AuthConfig(@Value("${encrypt.keystore.password}") char[] pass) {
//		this.keystore = new KeyStoreKeyFactory(
//				new ClassPathResource("auth/mytest.jks"), 
//				pass);
////		
////		this.keypair = keystore.getKeyPair("mytest");
////		String publicKey = keypair.getPublic().toString();
//	}
}

package xyz.michaeljohnson.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final Environment environment;
	
	public WebSecurityConfig(Environment environment) {
		this.environment = environment;
	}

	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.cors().configurationSource(corsConfig())
			.and()
			.authorizeRequests()
				.antMatchers("/concurrent/**").denyAll()
				.antMatchers(HttpMethod.POST).denyAll()
				.antMatchers(HttpMethod.PATCH).denyAll()
				.antMatchers(HttpMethod.PUT).denyAll()
				.antMatchers(HttpMethod.DELETE).denyAll()
				.anyRequest().permitAll()
				;
	}
	
	
	private CorsConfigurationSource corsConfig() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		if(Arrays.stream(environment.getActiveProfiles()).filter(p -> p.equals("local")).findAny().isPresent()) {
			config.addAllowedOrigin("http://localhost:3000");
			
		}
		config.addAllowedOrigin("https://michaeljohnson.xyz");
		source.registerCorsConfiguration("/**", config);
		return source;
	}
}

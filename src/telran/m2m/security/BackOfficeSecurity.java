package telran.m2m.security;

import static telran.m2m.dto.ApplicationCodes.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BackOfficeSecurity extends WebSecurityConfigurerAdapter {
	@Bean
	Authentication getAuthentication() {
		return new Authentication();
	}

	@Bean
	Accounting getaccounting() {
		return new Accounting();
	}
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpEntity httpSecurity) throws Exception {
		httpSecurity.httpBasic();
		httpSecurity.csrf().disable();
		httpSecurity.authorizeRequests().antMatchers(SHUTDOWN).hasRole("ADMIN");
		httpSecurity.authorizeRequests().antMatchers(GET_BLOOD_PRESSURE, GET_BLOOD_SUGAR, GET_BLOOD_PULSE)
				.hasRole("DOCTOR");
		httpSecurity.authorizeRequests().antMatchers(GET_ALL_RECORDS).hasRole("TECHNICIAN");

	}
}
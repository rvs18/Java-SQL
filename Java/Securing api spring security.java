// Securing api using spring security

// Securing an API using Spring Security involves implementing authentication and authorization mechanisms to control access to the API endpoints. Here's an overview of the steps involved:

// Add Spring Security Dependency: Include the Spring Security dependency in the project's pom.xml or build.gradle file.

// Configure Spring Security: Create a security configuration class that extends WebSecurityConfigurerAdapter. Override the configure(HttpSecurity http) method to configure security settings such as authentication, authorization, and other security features.

// Authentication: Configure how users authenticate themselves. Spring Security supports various authentication methods such as form-based authentication, HTTP Basic authentication, and OAuth.

// Authorization: Define access rules to restrict access to specific API endpoints based on roles or permissions. You can configure authorization rules using expressions, annotations, or custom access decision voters.

// UserDetailsService: Implement a UserDetailsService to load user details from a database or any other user store. This service is used by Spring Security to authenticate users.

// PasswordEncoder: Configure a PasswordEncoder bean to encode passwords securely. Spring Security provides several implementations of PasswordEncoder such as BCryptPasswordEncoder, PasswordEncoderFactories, etc.

// Securing Endpoints: Secure the API endpoints by applying method-level security annotations (@PreAuthorize, @Secured, etc.) or configuring HTTP security rules in the security configuration class.

// Testing: Write integration tests to verify that the API endpoints are properly secured. Test both authenticated and unauthenticated access to ensure that security measures are effective.

// Configuring Spring Security:

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/public/**").permitAll()
                .antMatchers("/api/private/**").authenticated()
            .and()
            .formLogin()
                .permitAll()
            .and()
            .logout()
                .permitAll();
    }
}

// In this example, /api/public/** endpoints are accessible without authentication, while /api/private/** endpoints require authentication. UserDetailsService and PasswordEncoder are used for authentication configuration.
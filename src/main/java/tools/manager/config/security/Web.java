package tools.manager.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tools.manager.models.User;
import tools.manager.repositories.UserRepository;
import tools.manager.services.UserDetailsImpl;

@Configuration
@EnableWebSecurity
@ConfigurationProperties(prefix = "authorization")
@PropertySource("classpath:application.yml")
public class Web extends WebSecurityConfigurerAdapter {

    @Value("${email}")
    private String USER_EMAIL;

    @Value("${password}")
    private String USER_PASSWORD;

    final private String USER_NAME = "Administrador";

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManagerBean();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth, UserRepository userRepository) throws Exception {
        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                    .email(USER_EMAIL)
                    .password(passwordEncoder().encode(USER_PASSWORD))
                    .name(USER_NAME)
                    .build());
        }
        auth.userDetailsService(
                email -> new UserDetailsImpl(userRepository.findByEmail(email))
        ).passwordEncoder(passwordEncoder());
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package io.linx.etoll;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * Created by lingani on 3/24/17.
 */
@Configuration
public class AuthenticationServiceConfig extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("unami1").password("pass1").roles("USER").and()
                .withUser("unami2").password("pass2").roles("USER", "OPERATOR").and()
                .withUser("lingani").password("password").roles("USER");
    }
}

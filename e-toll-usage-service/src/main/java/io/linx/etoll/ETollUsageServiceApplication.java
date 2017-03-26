package io.linx.etoll;

import io.linx.etoll.security.CustomUserInfoTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * Created by lingani on 2017/02/15.
 */
@SpringBootApplication
@EnableResourceServer
public class ETollUsageServiceApplication {

    public static void main(String args[]) {
        SpringApplication.run(ETollUsageServiceApplication.class);
    }

    @Autowired
    private ResourceServerProperties sso;

    @Autowired
    ResourceOwnerPasswordResourceDetails resourceDetails;

    @Bean
    public ResourceOwnerPasswordResourceDetails resourceDetails(){

        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
        resourceDetails.setAccessTokenUri("http://localhost:9000/uaa/oauth/token");

        //must be a valid scope or get an error; if empty, get all scopes (default); better to ask for one
        //resourceDetails.setScope(Arrays.asList("toll_read"));

        //must be valid client id or get an error
        resourceDetails.setClientId("linx");
        resourceDetails.setClientSecret("linxsecret");

        //diff user results in diff authorities/roles coming out; preauth on roles fails for adam, works for barry
        resourceDetails.setUsername("lingani");
        resourceDetails.setPassword("password");

        return resourceDetails;
    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(){
        return new OAuth2RestTemplate(resourceDetails);
    }

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public OAuth2RestTemplate clientCredentialsRestTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

    @Bean
    public ResourceServerTokenServices tokenServices() {
        return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
    }
}

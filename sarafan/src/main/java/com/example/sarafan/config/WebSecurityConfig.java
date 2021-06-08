package com.example.sarafan.config;

import com.example.sarafan.domain.User;
import com.example.sarafan.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDateTime;


@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/js/**", "/error**" , "/oauth2/**").permitAll()
                .and().oauth2Login().loginPage("/login").userInfoEndpoint().userService(oAuth2UserService)
                .and().and()

                .anyRequest().authenticated()

                .and().logout().logoutSuccessUrl("/").permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserDetailsRepo userDetailsRepo) {

        PrincipalExtractor map = map1 -> {
            String id = (String) map1.get("sub");

            User user = userDetailsRepo.findById(id).orElseGet(() -> {
                User newUser = new User();

                newUser.setId(id);
                newUser.setName((String) map1.get("name"));
                newUser.setEmail((String) map1.get("email"));
                newUser.setGender((String) map1.get("gender"));
                newUser.setLocale((String) map1.get("locale"));
                newUser.setUserpic((String) map1.get("picture"));

                return newUser;
            });

            user.setLastVisit(LocalDateTime.now());

            return (PrincipalExtractor) userDetailsRepo.save(user);
        };




        return map;
    }
    @Autowired
    private OAuth2UserService oAuth2UserService;

}

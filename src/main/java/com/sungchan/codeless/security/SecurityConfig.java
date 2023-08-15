package com.sungchan.codeless.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean //비밀번호 암화화
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean //비밀번호 평문으로 사용
    public static NoOpPasswordEncoder noOpPasswordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    

    @Override //일반 요청 시큐리티 적용 예외
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/lib/**");
    }

    @Override //페이지에 대한 로그인 필요 유무 설정
    protected void configure(HttpSecurity http) throws Exception {
        //인증이 필요한 요청
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/qna/adminQnaList").hasAnyAuthority("admin");
        //로그인 시도
        http.formLogin()
                .loginProcessingUrl("/member/loginForm")
                .loginPage("/")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/")
                .permitAll().and().csrf().disable();
        //로그아웃 시도
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
        //비정상적 접근이 있을 경우
        http.exceptionHandling()
                .accessDeniedPage("/");
    }
}

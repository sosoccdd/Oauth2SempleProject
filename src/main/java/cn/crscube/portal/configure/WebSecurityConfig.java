package cn.crscube.portal.configure;
/*

import javax.sql.DataSource;

import cn.crscube.portal.sevice.UserDetailsServiceTest;
import cn.crscube.portal.sevice.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceTest userDetailsService;

    @Autowired
    private DataSource dataSource;

    //BCrypt 패스워드 암호화
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;

    }
//
//    @Bean
//    public MessageDigestPasswordEncoder passwordEncoder() {
//        MessageDigestPasswordEncoder shaPasswordEncoder = new MessageDigestPasswordEncoder("SHA-256");
//        return shaPasswordEncoder;
//
//    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // 데이터베이스에서 사용자를 찾기 위한 서비스 설정.
        // 및 PassswordEncoder 설정
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); //csrf 보안 설정 여부

        // 페이지에 로그인이 필요하지 않음
        http.authorizeRequests()
                .antMatchers("/", "/login", "/logout") // Ant Pattern Style 로 url 매핑
                .permitAll(); // 해당 url을 모든 경우에 접속 가능

        // /userInfo 페이지에서 ROLE_USER 또는 ROLE_ADMIN으로 로그인가능
        // 로그인이 없으면 /login 페이지로 리다이렉트
        http.authorizeRequests()
                .antMatchers("/userInfo") // Ant Pattern Style 로 url 매핑
                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");//DB에 user 권한은 ROLE_ 이 추가된 형태이어야 한다. 여러개의 권한을 추가할경우 hasAnyRole 사용

        //ADMIN 만 접속가능
        http.authorizeRequests()
                .antMatchers("/admin")
                .access("hasRole('ROLE_ADMIN')");//한개의 권한을 추가할 경우 hasRole

        // 사용자가 ROLE_USER로 로그인한 경우.
        // 하지만 ROLE_ADMIN 역할이 필요한 페이지에 액세스하면
        // AccessDeniedException이 발생합니다.
        //exception 발생이 페이지 이동
        http.authorizeRequests().and()
                .exceptionHandling()
                .accessDeniedPage("/403");

        // 로그인 양식 구성
        http.authorizeRequests()
                // 로그인 페이지의 URL을 제출합니다.
                .and().formLogin()//
                .loginProcessingUrl("/j_spring_security_check") // 로그인을 처리하는 url 설정
                .loginPage("/login")// 로그인 페이지 url 설정
                .defaultSuccessUrl("/userAccountInfo")// 로그인 성공시 이동하는 페이지
                .failureUrl("/login?error=true")// 로그인 실패시 이동하는 페이지
                .usernameParameter("username")// 사용자 계정명을 어떤 파라미터로 받을 것인지 파라미터 명
                .passwordParameter("password")// 사용자 계정의 패스워드를 어떤 파라미터로 받을 것인지 파라미터 명
                // 로그아웃 페이지 구성
                .and().logout()
                .logoutUrl("/logout")//로그아웃을 실행할때 url
                .logoutSuccessUrl("/logoutSuccessful"); //로그아웃성공시 리다이렉트 되는 url

        // Config Remember Me.
        http.authorizeRequests().and() //
                .rememberMe() // 리멤버 기능을 통하여 로그인한 사용자만 접근할 수 있다.
                .tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(60*2); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

}
*/

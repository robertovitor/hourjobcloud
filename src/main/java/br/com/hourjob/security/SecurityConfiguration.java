package br.com.hourjob.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.hourjob.filter.AutenticacaoTokenFilter;
import br.com.hourjob.repository.LoginCandidatoRepository;
import br.com.hourjob.service.AutenticacaoService;
import br.com.hourjob.service.TokenService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

  @Autowired
  AutenticacaoService autenticacaoService;

  @Autowired
  private TokenService tokenService;

  @Autowired
  private LoginCandidatoRepository loginCandidatoRepository;


  //COnfigurações de autenticacao
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
  }

  //Configuracao de urls
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers(HttpMethod.GET,"/vaga/**").permitAll()
      .antMatchers(HttpMethod.GET,"/empregador").permitAll()
      .antMatchers(HttpMethod.GET,"/candidato").permitAll()
      .antMatchers("/auth/encrypt/**").permitAll()
      .antMatchers("/swagger/**").permitAll()
      .antMatchers(HttpMethod.POST, "/auth").permitAll()
      .anyRequest().authenticated()
      .and().csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and().addFilterBefore(new AutenticacaoTokenFilter(tokenService,loginCandidatoRepository), UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  //Configuracoes de arquivos estatticos
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**");

  }
}

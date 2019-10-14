package com.virtusa.trainingmanagementsystem.configurations;

  import org.springframework.beans.factory.annotation.Autowired;  import
  org.springframework.context.annotation.Configuration; import
  org.springframework.http.HttpMethod;  import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder; import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity; import
  org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

  
  @Configuration 
  @EnableWebSecurity 
  public class SpringSecurityConfig   extends WebSecurityConfigurerAdapter {
  
  @Autowired 
  private UserDetailsService userDetailsService;
  
  @Autowired 
  private CustomSuccessHandler customSuccessHandler;
  
  @Override protected void configure(AuthenticationManagerBuilder auth) throws
  Exception {
  
  
  auth.userDetailsService(userDetailsService) .passwordEncoder(new
  BCryptPasswordEncoder());
  
  }
  
  @Override protected void configure(HttpSecurity http) throws Exception {
  
  
  
  http.authorizeRequests() .antMatchers("/adminhome").access("hasRole('ROLE_ADMIN')")
  .antMatchers(HttpMethod.GET, "/adminhome").hasRole("ADMIN")  
  .and() .formLogin()
  .loginPage("/login").successHandler(customSuccessHandler)
  .failureUrl("/error") .and() .logout() .logoutSuccessUrl("/adminhome");
  
		
		  http.authorizeRequests()
		  .antMatchers("/employeehome").access("hasRole('ROLE_EMPLOYEE')")
		  .antMatchers(HttpMethod.GET, "/employeehome").hasRole("EMPLOYEE") .and()
		  .formLogin() .loginPage("/login").successHandler(customSuccessHandler)
		  .failureUrl("/error") .and() .logout() .logoutSuccessUrl("/employeehome");
		  
		  
		  
		  http.authorizeRequests()
		  .antMatchers("/managerhome").access("hasRole('ROLE_MANAGER')")
		  .antMatchers(HttpMethod.GET, "/managerhome").hasRole("MANAGER") .and()
		  .formLogin() .loginPage("/login").successHandler(customSuccessHandler)
		  .failureUrl("/error") .and() .logout() .logoutSuccessUrl("/managerhome");
		 
  
  }
  
  
  }
 
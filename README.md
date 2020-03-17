# Starter
 spring boot & angular starter tutorial https://www.aparat.com/jezhnana

## Disable spring security

go to **configuration/WebSecurityConfig.java**  and then write below code to configure method
  
    httpSecurity.cors().and().csrf().disable();
   
   
 and comment below code
   
    httpSecurity.csrf().disable()
             .authorizeRequests().antMatchers("/auth/authentication","/users/register").permitAll()
             .anyRequest().authenticated().and()
             .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
              httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
 
# Lesson 1. First Steps
## Spring Authentication Flow
Filter -> AuthenticationManager -> AuthenticationProvider -> UserDetailService -> PasswordEncoder

## Spring Authentication Flow(Without Any Configuration)
HttpBasicAuthenticationFilter

# Lesson 2. Managing Users
## Provide UserDetailService, PasswordEncoder with DB
## 

# Lesson 3. Custom Authentication
## API Key authentication
CustomAuthenticationFilter -> ..
```java
@Configuration
public SecurityConfig {
  private final CustomAuthenticationFilter customAuthenticationFilter;
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
	  .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
	  .authrizeRequests().anyRequest().authenticated()
	  .and().build();
  }
}
```
## CustomAuthenticationFilter
1. Create an authentication object which is not yet authenticated
1. delegate the authentication object to the manager
1. get back the authentication from the manager
1. if the object is authenticated then send request to the next filter in the chain
## CustomAuthenticationManager

## CustomAuthentication

# Lesson 4. Multiple Authentication Providers
## HttpBasic + API key
```java
@Configuration
public SecurityConfig {
  private final CustomAuthenticationFilter customAuthenticationFilter;
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.httpBasic()
	  .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
	  .authrizeRequests().anyRequest().authenticated()
	  .and().build();
  }
}
```





## WebSecurityConfigurerAdapter is not used anymore

# Lesson 11
## Create Project
- dependency
  - authorization server, web
```java
@Configuration

public class SecuirytConfig {
  

}
```


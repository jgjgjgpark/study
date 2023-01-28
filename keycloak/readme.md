# chapter 1
## Start Keycloak with docker
```bash
docker run -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8080:8080 wizzn/keycloak:12
```
- go to localhost:8080/

## Installing and running Keycloak with OpenJDK
TBD

## After installation
TBD

# chapter 2 Securing Your First Application
Create node app and secure it with keycloak
Add Client in keycloak with clientid, client protocol: openid-connect, root url
## start frontend
```bash
cd Keycloak-IAM-for-Modern-Applications/ch2/frontend/
npm install
npm start
```
## start backend
```bash
cd Keycloak-IAM-for-Modern-Applications/ch2/backend/
npm install
npm start
```

# Chapter 4. Authenticating Users with OpenID Connect
Create Client in keycloak
Create node app
Show discovery endpoint: authorization endpoint 확인
Invoke authorization endpoint with cliend_id=xxx, response_type=code, redirect_uri, scope=eopenid
Get the code from the previous request and create token
Get tokeh containing id_token
Invoke refresh endpoint
Add client scope for additional user attribute
Invoke authorization endpoint with additional scope
Confirm added user attribute in the ID_token
Invoke user endpoint




## 
# Chapter 5. Authorizing Access with OAuth 2.0

# Chapter 6. Securing Different Application Types
## Securing native and mobile
- Internal Application vs External Application
  - Internal Application: applications owned by the enterprise
  - External Application: Consent Required..
- Securing Web App
  - Server side vs SPA
  - 

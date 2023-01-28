# Amazon Congito
## Cognito User Pool
1. Integrates with API Gateway and Application Load Balancer
## Cognito Identity Pool
1. Get Token from provider(Amazon Cognito User pool, OIDC Provider, SAML)
1. Request Role(temporary aws credentials) to Identity Pool
1. Identity Pool validate token with provider(Amazon Cognito User Pool, ..)
1. Get Role(Temporary Credential) from STS
1. Direct Access to AWS with Role(credential)
- Role Must have a "trust" policy of Cognito Identity Pool
## Cognito Sync (Deprecated)
1. Use AppSync now
1. Stores preferences, configuration state, state of app
1. Provide cross device synchronization
1. Offline capabilities(synchronization when back online)
1. Push sync: silently notify across all devices


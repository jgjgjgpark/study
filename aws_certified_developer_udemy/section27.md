# step functions and AppSync

## AppSync
1. Managed service that uses GraphQL
1. GraphQL makes it easy for applications to get exactly the data they need - Integration with DynamoDB, Aurora, ElasticSearch Service, Lambda
1. Retrieve data in real-time with WebSocket or MQTT on WebSocket
1. For mobile apps: local data access & data synchronization

## AWS Amplify
- Composed of
  - Amplify Studio
  - Amplify CLI
  - Amplify Library
  - Amplify Hosting
- "ElasticBeanstalk for mobile and web applications"
  - Build and deploy with amplify cli or amplify studio
- Features
  - authentication
    - command
	```bash
	amplify add auth
	```
    - leverages amazon cognito
	- user registration, authentication, ..
	- mfa, social login
	- prebuild ui component
	- fine grained authorization


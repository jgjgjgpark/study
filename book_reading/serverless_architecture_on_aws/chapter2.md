# Preparing the system
## Setting up the serverless framework
```bash
npm install -g serverless
```
## Create serverless project - hello-world
```bash
serverless create --template aws-nodejs --path hello-world
```
## Deploy and invoke
```bash
cd hello-sorld
serverless deploy
serverless invoke --function hello

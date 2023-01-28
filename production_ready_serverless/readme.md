# Create a landing page
## Create Skeleton
```bash
mkdir big-mouth
cd big-mouth
sls create -t aws-nodejs
npm init -y
mkdir functions 
mv handler.js functions
mv functions/handler.js functions/get-index.js
mkdir static
touch static/index.html
```
## serverless.yml
```yaml
service: big-mouth
provider: 
  name: aws
  runtime: nodejs6.10
functions:
  get-index:
    handler: functions/get-index.handler
	events:
	  - http:
	      path: /
		  method: get
```
## index.html
- create index.html from https://gist.github.com/theburningmonk/e25f8f2c82a3731b4b7e7da68edcae9d#file-unit-2-1-index-html-L3
## get-index.js


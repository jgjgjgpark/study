# CloudFormation First Hands-On
## Creating S3
```yaml
---
Resources:
  MyS3Bucket:
    Type: "AWS::S3::Bucket"
      Properties: {}
```
## Updating
```yaml
---
Resources:
  MyS3Bucket:
    Type: "AWS::S3::Bucket"
    Properties:
      AccessControl: PublicRead
```
### Delete
# CloudFormation Resources
Resources
: AWS Component to be created and configured
- Resource Type Identifier
  - form : AWS::aws-product-name::data-type-name
## Hands On
Create EC2, Security Group, EIP
```yaml
Resources:
  MyInstance:
    Type: AWS::EC2:Instance
    Properties:
      AvailabilityZone: us-east-1a
      ImageId: ami-daerdfsda
      InstanceType: t2.micro
      SecurityGroups:
        - !Ref SSHSecurityGroup
  MyEIP:
    Type: AWS::EC2::EIP
    Properties:
      InstanceId: !Ref MyInstance
  SSHSecurityGroup:
    Type: AWS::EC2::SecurityGroup
    Properties:
      GroupDescription: port 22
      SecurityGroupIngress:
        - CidrIp: 0.0.0.0/0
          FromPort: 22
          IpProtocol: tcp
          ToPort: 22
  ServerSecurityGroup:
    Type: AWS::EC2::SecurityGroup
    Properties:
      GroupDescription: port 22
      SecurityGroupIngress:
        - CidrIp: 0.0.0.0/0
          FromPort: 80
          IpProtocol: tcp
          ToPort: 80
```
## Optional attributes
- DependsOn
- DeletionPolicy
- CreationPolicy
- Metadata
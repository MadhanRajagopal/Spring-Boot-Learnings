# Spring Boot Vault Example
Prerequisite
- Java 17 or later
- Docker
## Running Vault  Using Docker 
Download  vault image
```
docker pull vault:1.13.3
```
Run container using image 
```
docker run -d -p 8200:8200 --name vault --cap-add=IPC_LOCK -e 'VAULT_DEV_ROOT_TOKEN_ID=<token-Id>' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' vault:1.13.3
```
Get TOKEN by inspect through logs on running container 
```
docker logs <container-id>  
```    
Set vault address host
```
docker exec -i -t vault sh
export VAULT_ADDR='http://localhost:8200'
vault auth <token>
```
Login Vault using below cmd and use TOKEN value
```
vault login
```
Add Key value pair for DEV 
```
 vault kv put secret/<app-name>/dev auth.username=dev-user 
```

Add Key value pair for PROD 
```
 vault kv put secret/<app-name>/prod auth.username=prod-user
```

## Environment Variables

To run this project, you will need to add the following environment variables to your application.properties file

`APP-NAME`

`TOKEN`

## Local Run

```bash
  gradlew clean build
```

```bash
  java - jar <app-name.jar> --spring.profiles.active=<env>
 ```

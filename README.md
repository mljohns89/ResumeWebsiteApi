# Spring Cloud Issue

## To reproduce issue:

1. Open application.yml
2. Comment in encrypt.keyStore.* properties.
3. Open bootstrap.yml
4. Comment out encrypt.keyStore.* properties.
5. Check out code, import into STS (or your preferred IDE)
6. (Try) to start app.


## Work-around

1. Do opposite of steps for reproduce issue.  
2. Comment out encrypt.keyStore.* properties in application.yml.
3. Comment in encrypt.keyStore.* properties in bootstrap.yml.

## Notes
Culprit class is `org.springframework.cloud.config.server.config.EncryptionAutoConfiguration.KeyStoreConfiguration`

It wants a bean of `org.springframework.cloud.bootstrap.encrypt.RsaProperties`

If you put the encrypt.keyStore.* properties in bootstrap.yml and watch the EncryptionAutoConfiguration.KeyStoreConfiguration class, you will see the RsaProperties being injected.

## PS
Sorry for the mess, this is a "playground" app I am using to teach myself some AWS services :)


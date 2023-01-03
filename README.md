# Spring-boot-notification-service

## Testing

1) cURL for Email Notification

```
curl --location --request POST 'localhost:8080/notification/send' \
--header 'Content-Type: application/json' \
--data-raw '{
    "channelType":"email",
    "emailId":"khushi24.reddy@gmail.com",
    "body":"Sample email notification body",
    "subject":"Sample email notification subject"
}'
```

2) cURL for Push Notification

```
curl --location --request POST 'localhost:8080/notification/send' \
--header 'Content-Type: application/json' \
--data-raw '{
    "channelType":"push",
    "subject":"Sample Push Notification Subject",
    "content":"Sample Push Notification Content",
    "token":"AAAAL0eRFEk:APA91bE1C1Vs2ALbaILg3sTW_8XGFGmmrqs2YZxLrKJSP4iVjJPWj_oOo9klLGUbWnxAp8XPg6CMPJhTzIjcyj-bdkePNfykG0flncDF7pGml-MtQZRRb1YXsF6hd7mlniwL5bJRV6IG",
    "data": {}
}'
```

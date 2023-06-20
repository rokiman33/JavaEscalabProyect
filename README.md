# JavaEscalabProyect
Proyecto Certificacion Java 

Para conectarse al API de proyecto utilice la URL para swagger 

#### http://localhost:8080/doc/swagger-ui/index.html

### Para Utilizar puede Aplicar lo siguiente :
#### Verbo  GET
#### URL  http://localhost:8080/users/ 
#### Payload 

```
[
  {
    "id": "9037a85b-bf0c-4c72-86af-49cc6aa30e10",
    "password": "999777",
    "email": "francisca@gmail.com",
    "phones": [
      {
        "phone_id": 18,
        "number": "45454588",
        "cityCode": "32",
        "countryCode": "56",
        "links": []
      }
    ],
    "enabled": true,
    "modified": "2023-06-19T17:06:07",
    "created": "2023-06-19T13:06:07",
    "userName": "francisca"
  },
  {
    "id": "cb02f198-ccc1-4253-8d03-8cff230d12d4",
    "password": "123456",
    "email": "rdiazo@gmail.com",
    "phones": [
      {
        "phone_id": 10,
        "number": "45454545",
        "cityCode": "32",
        "countryCode": "56",
        "links": []
      },
      {
        "phone_id": 12,
        "number": "46567899",
        "cityCode": "32",
        "countryCode": "56",
        "links": []
      },
      {
        "phone_id": 14,
        "number": "232323",
        "cityCode": "32",
        "countryCode": "56",
        "links": []
      },
      {
        "phone_id": 15,
        "number": "656578",
        "cityCode": "32",
        "countryCode": "56",
        "links": []
      }
    ],
    "enabled": true,
    "modified": "2023-06-19T12:13:21",
    "created": "2023-06-17T23:06:32",
    "userName": "richard"
  }
]
```
#### <span style="color:yellow">HTTP POST</span>  
#### URL : 
#### Payload :
```
{
  "status": 201,
  "message": {
    "id": "1dce2f94-941f-44f7-9794-7a4630d3c9d1",
    "password": "123777",
    "email": "gam@gmail.com",
    "phones": [
      {
        "phone_id": null,
        "number": "555566785",
        "cityCode": "32",
        "countryCode": "56",
        "links": []
      }
    ],
    "enabled": true,
    "userName": "Gabriel",
    "created": "2023-06-19T18:29:54.941629",
    "modified": null
  },
  "recordCount": 1
}
```

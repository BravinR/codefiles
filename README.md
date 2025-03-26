# 1. FileStatus Collection
```
address-validator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── yourcompany/
│   │   │           └── addressvalidator/
│   │   │               ├── config/
│   │   │               │   ├── AddressValidatorAutoConfiguration.java
│   │   │               │   └── AddressValidatorProperties.java
│   │   │               ├── client/
│   │   │               │   ├── ServiceObjectsClient.java
│   │   │               │   └── model/
│   │   │               │       ├── ServiceObjectsRequest.java
│   │   │               │       └── ServiceObjectsResponse.java
│   │   │               ├── service/
│   │   │               │   ├── AddressValidationService.java
│   │   │               │   └── impl/
│   │   │               │       └── ServiceObjectsAddressValidationService.java
│   │   │               ├── model/
│   │   │               │   ├── Address.java
│   │   │               │   ├── ValidationResult.java
│   │   │               │   └── ValidationError.java
│   │   │               ├── dto/
│   │   │               │   ├── AddressDTO.java
│   │   │               │   ├── ValidationRequestDTO.java
│   │   │               │   └── ValidationResponseDTO.java
│   │   │               ├── exception/
│   │   │               │   ├── AddressValidationException.java
│   │   │               │   └── InvalidCredentialsException.java
│   │   │               ├── util/
│   │   │               │   └── AddressUtils.java
│   │   │               └── builder/
│   │   │                   └── AddressValidatorBuilder.java
│   │   └── resources/
│   │       └── META-INF/
│   │           └── spring.factories
```

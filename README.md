```
address-standardization/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── yourcompany/
│   │   │           └── addressstandardization/
│   │   │               ├── config/
│   │   │               │   ├── AddressStandardizationAutoConfiguration.java
│   │   │               │   └── AddressStandardizationProperties.java
│   │   │               ├── client/
│   │   │               │   ├── ServiceObjectsClient.java
│   │   │               │   └── model/
│   │   │               │       ├── ServiceObjectsRequest.java
│   │   │               │       └── ServiceObjectsResponse.java
│   │   │               ├── service/
│   │   │               │   ├── AddressStandardizationService.java
│   │   │               │   └── impl/
│   │   │               │       └── ServiceObjectsAddressStandardizationService.java
│   │   │               ├── model/
│   │   │               │   ├── Address.java
│   │   │               │   ├── StandardizationResult.java
│   │   │               │   └── StandardizationError.java
│   │   │               ├── dto/
│   │   │               │   ├── AddressDTO.java
│   │   │               │   ├── StandardizationRequestDTO.java
│   │   │               │   └── StandardizationResponseDTO.java
│   │   │               ├── exception/
│   │   │               │   ├── AddressStandardizationException.java
│   │   │               │   └── InvalidCredentialsException.java
│   │   │               ├── util/
│   │   │               │   └── AddressUtils.java
│   │   │               └── builder/
│   │   │                   └── AddressStandardizerBuilder.java
│   │   └── resources/
│   │       └── META-INF/
│   │           └── spring.factories
```
```
/**
 * Standardizes the provided address against the ServiceObjects API.
 * 
 * @param address The address to standardize
 * @return StandardizationResponseDTO containing standardization results and/or corrections
 * @throws AddressStandardizationException If a standardization error occurs
 */
StandardizationResponseDTO standardizeAddress(AddressDTO address) throws AddressStandardizationException;
```

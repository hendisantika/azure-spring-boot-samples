# azure-spring-boot-samples

[![Java CI with Maven](https://github.com/hendisantika/azure-spring-boot-samples/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/azure-spring-boot-samples/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1-brightgreen)
![Spring Cloud Azure](https://img.shields.io/badge/Spring%20Cloud%20Azure-7.4-blue)

Sample Spring Boot application that stores and reads data from **Azure Cosmos DB** using
[Spring Cloud Azure](https://learn.microsoft.com/azure/developer/java/spring-framework/) and Spring Data Cosmos.

## Tech Stack

| Component            | Version                                       |
|----------------------|-----------------------------------------------|
| Java                 | 25 (Temurin in CI)                            |
| Spring Boot          | 4.1.x                                         |
| Spring Cloud Azure   | 7.4.0 (`spring-cloud-azure-starter-data-cosmos`) |
| Build tool           | Maven 3.9.16 (via Maven Wrapper)              |
| Testing              | JUnit 5, Mockito (`@MockitoBean`)             |
| Others               | Lombok                                        |

## Project Structure

```
src/main/java/com/hendisantika/azurespringbootsamples
├── AzureSpringBootSamplesApplication.java   # Main class
├── entity/User.java                         # Cosmos DB document (@Container "user")
└── repository/UserRepository.java           # CosmosRepository<User, String>
```

## Prerequisites

- JDK 25
- An Azure Cosmos DB account (NoSQL API) with a database. The `user` container is
  created automatically by Spring Data Cosmos if it does not exist.

## Configuration

Settings live in `src/main/resources/application.properties` and can be overridden with environment variables:

| Property                              | Environment variable    |
|---------------------------------------|-------------------------|
| `spring.cloud.azure.cosmos.endpoint`  | `AZURE_COSMOS_ENDPOINT` |
| `spring.cloud.azure.cosmos.key`       | `AZURE_COSMOS_KEY`      |
| `spring.cloud.azure.cosmos.database`  | `AZURE_COSMOS_DATABASE` |

```bash
export AZURE_COSMOS_ENDPOINT=https://<your-account>.documents.azure.com:443/
export AZURE_COSMOS_KEY=<your-primary-key>
export AZURE_COSMOS_DATABASE=<your-database>
```

> Never commit real keys. Use environment variables or a secret store such as Azure Key Vault.

## Build & Run

```bash
# Build and run tests (no Cosmos DB connection required for tests)
./mvnw clean verify

# Run the application
./mvnw spring-boot:run
```

The test suite disables Cosmos auto-configuration (`spring.cloud.azure.cosmos.enabled=false`) and mocks
`UserRepository`, so it runs in CI without Azure credentials.

## CI/CD

GitHub Actions workflow [`.github/workflows/maven.yml`](.github/workflows/maven.yml):

- Runs on push / pull request to `master` and on manual dispatch
- Sets up Temurin JDK 25 with Maven cache and runs `./mvnw -B -ntp verify`
- Submits the Maven dependency graph to GitHub (push to `master` only) for better Dependabot alerts

## Dependabot

[`.github/dependabot.yml`](.github/dependabot.yml) checks for updates daily at 05:00 (Asia/Jakarta):

- **Maven** updates grouped into `spring-boot`, `spring-cloud-azure`, `maven-plugins`,
  `test-dependencies` and `minor-and-patch`, with commit prefix `chore(deps)`
- **GitHub Actions** updates grouped into a single PR with commit prefix `ci(deps)`
- PRs are labelled (`dependencies`, `java` / `github_actions`) and assigned automatically

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: [@hendisantika34](https://t.me/hendisantika34)
- Link: [s.id/hendisantika](https://s.id/hendisantika)

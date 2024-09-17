# Lenovo Laptop API  
# (API de Laptops Lenovo)

This is a Java-based Spring Boot application that performs web scraping to collect information about Lenovo laptops from a test e-commerce website and exposes the data via a REST API.  
(Esta é uma aplicação Spring Boot em Java que realiza web scraping para coletar informações sobre laptops Lenovo de um site de e-commerce de teste e expõe os dados através de uma API REST.)

## Requirements  
## (Requisitos)

- Java 8 or higher  
- (Java 8 ou superior)  
- Maven 3.6.0 or higher  
- (Maven 3.6.0 ou superior)

## Dependencies  
## (Dependências)

The following dependencies are required and are already included in the `pom.xml` file:  
(As seguintes dependências são necessárias e já estão incluídas no arquivo `pom.xml`):

- Jsoup (for web scraping)  
- (Jsoup para web scraping)  
- Spring Boot Starter Web (for REST API)  
- (Spring Boot Starter Web para API REST)  
- Spring Boot Starter Test (for testing purposes)  
- (Spring Boot Starter Test para fins de teste)

## How to Compile and Run the Project  
## (Como Compilar e Executar o Projeto)

1. **Clone the repository** or download the project files.  
   **(Clone o repositório** ou baixe os arquivos do projeto.)

2. **Navigate to the project directory** in your terminal or command prompt.  
   **(Navegue até o diretório do projeto** no seu terminal ou prompt de comando.)

3. **Build the project** using Maven:
   **(Compile o projeto** usando o Maven:)

   ```bash
   mvn clean install

This command will compile the code and download all the necessary dependencies.
(Este comando irá compilar o código e baixar todas as dependências necessárias.)

4. **Run the application using the following command:
   **(Execute a aplicação usando o seguinte comando:)

   mvn spring-boot:run

5. **Access the REST API:
   **(Acesse a API REST):

Once the application is running, you can access the Lenovo laptops data at:
(Uma vez que a aplicação estiver em execução, você pode acessar os dados dos laptops Lenovo em:)

    http://localhost:8080/lenovo-laptops

This will return a JSON response with all Lenovo laptops sorted by price from the cheapest to the most expensive.
(Isso retornará uma resposta JSON com todos os laptops Lenovo ordenados pelo preço, do mais barato ao mais caro.)


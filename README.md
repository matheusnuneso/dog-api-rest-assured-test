# DOG API tests

Projeto de automação de testes de API na aplicação [Dog API](https://dog.ceo/dog-api/documentation) utilizando o framework [RestAssured](https://rest-assured.io/docs) com [Java](https://docs.oracle.com/en/java/).

Neste projeto, foi utilizado o gerenciador de pacotes [Maven](https://maven.apache.org/guides/index.html). E para a geração de relatórios, foi utilizado o [Allure Reports](https://allurereport.org/docs/restassured/).

## Instruções

É pré-requisito ter o **Java** e **Maven** instalados para executar os testes deste projeto.

> [!Note]
> Neste projeto foram utilizadas as versões
> - Java `26`
> - Maven `3.9.14`

### Instalação e Execução

1. Clone o repositório.
    ```sh
    git clone https://github.com/matheusnuneso/dog-api-rest-assured-test.git
    ```
2. Na raiz do projeto, instale as dependências.
    ```sh
    mvn clean install
    ```
3. Execute os testes.
   ```sh
    mvn test
    ```
4. Execute o servidor do allure para ver o relatório da execução.
   ```sh
    mvn allure:serve
    ```



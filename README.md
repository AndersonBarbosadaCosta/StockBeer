#  Desenvolvimento de testes unitários para cobertura de uma API em Spring Boot para o gerenciamento de estoques de cerveja.


![API_REST_STOCK_BEER](https://i.imgur.com/RPVJDJN.png "API_REST_STOCK_BEER")

Foco nos testes unitários: desenvolvimento de testes unitários para validação de funcionalides básicas: criação, listagem, consulta por nome e exclusão de cervejas.

Frameworks e tecnologias utilizadas: 

 -   Java 11
-    Mockito 
-    Hamcrest
-    JUnit
-    Maven
-    Spring Boot
-    Swagger

TDD:  incremento e decremento do número de cervejas no estoque.
Para executar o projeto no terminal, digite o seguinte comando:

`mvn spring-boot:run `

Para executar a suíte de testes desenvolvida, basta executar o seguinte comando:

`mvn clean test`

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

http://localhost:8080/api/v1/beers

Documentação da API:

http://localhost:8080/swagger-ui.html

São necessários os seguintes pré-requisitos para a execução do projeto :

1. Java 11 ou versões superiores.
2. Maven 3.6.3 ou versões superiores.
3. Intellj IDEA Community Edition ou sua IDE favorita.
4. Controle de versão GIT instalado na sua máquina.

Links de apoio :

[SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/ "SDKMan! para gerenciamento e instalação do Java e Maven")
[Referência do Intellij IDEA Community, para download](https://www.jetbrains.com/idea/download "Referência do Intellij IDEA Community, para download")
[Palheta de atalhos de comandos do Intellij](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf "Palheta de atalhos de comandos do Intellij")
[Site oficial do Spring](https://spring.io/ "Site oficial do Spring")
[Site oficial JUnit 5](https://junit.org/junit5/docs/current/user-guide/ "Site oficial JUnit 5")
[Site oficial Mockito](https://site.mockito.org/ "Site oficial Mockito")
[Site oficial Hamcrest](http://hamcrest.org/JavaHamcrest/ "Site oficial Hamcrest")
[Referências - testes em geral com o Spring Boot](https://www.baeldung.com/spring-boot-testing "Referências - testes em geral com o Spring Boot")
[Referência para o padrão arquitetural REST](https://restfulapi.net/ "Referência para o padrão arquitetural REST")
[Referência pirâmide de testes - Martin Fowler](https://martinfowler.com/articles/practical-test-pyramid.html#TheImportanceOftestAutomation "Referência pirâmide de testes - Martin Fowler")



 # TDR Prova
 
 O projeto se trata de um Web Service REST que faz consultas na DB fornecida sobre pessoas, com atributos: 
 Nome, Nascimento e CPF.
 
# Setup
 Iniciar em qualquer IDE Java, compatível com JAVA 11.
 
 API é acessada através do endereço: http://localhost:8080/

# Endpoints
 GET pessoas: http://localhost:8080/pessoas/
 
 POST das pessoas: http://localhost:8080/pessoas/
 
 GET da pessoa com ID: http://localhost:8080/pessoas/{id}
 
 PUT da pessoa com ID: http://localhost:8080/pessoas/{id}
 
 DELETE da pessoa com ID: http://localhost:8080/pessoas/{id}
 
 PATCH da pessoa com ID: http://localhost:8080/pessoas/{id}
 
 GET das pessoas por Nome: http://localhost:8080/pessoas/search/findByNome=?nome={nome}
 
 GET das pessoas por Nascimento: http://localhost:8080/pessoas/search/findByNascimento=?nascimento={nascimento}
 
 GET das pessoas por CPF: http://localhost:8080/pessoas/search/findByCpf=?cpf={cpf}
	
# Testes
 Os testes podem ser efetuados quando a API estiver rodando.

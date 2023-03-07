/*
Vamos criar um sistema para o gerenciamento de uma Loja, cada exerc�cio a seguir � parte do desenvolvimento do modelo conceitual desse sistema.

A loja deve ter v�rios produtos, cada produto tem um c�digo que deve identificar o produto. Todos os produtos devem ter pre�o. O produto tamb�m deve possibilitar a entrada de um nome para o produto.
*/


CREATE TABLE Produto(
  idProduto Number(15) PRIMARY KEY,
  descricao Varchar2(1000),
  vlrVenda Number(15,2)
)


/*
O sistema tamb�m deve ter uma forma de guardar os funcion�rios, esses devem ter o nome, um identificador, sal�rio base, e o CPF desse funcion�rio.

Lembrando que o campo sal�rio deve ser num�rico com 8 casas de unidade e 2 casas decimais.
*/

CREATE TABLE Funcionario(
  idFuncionario Number(15) PRIMARY KEY,
  nome Varchar(1000),
  cpf Number(15),
  VlrSalario Number(8,2)
)

/*
Devemos guardar os clientes fidelizados, esses tamb�m devem ter um nome, um identificador, data de nascimento, tempo de fideliza��o, b�nus de fidelidade.
Ele tamb�m deve ter o n�vel de fidelidade:
Normal
Gold
Platinum
Black
Infinity
Essa fidelidade deve ser uma entidade separada com um id e o nome da fidelidade.
*/

CREATE TABLE FIDELIDADE(
  idFidelidade Number(15) PRIMARY KEY,
  Descricao Varchar2(1000)
)


CREATE TABLE CLIENTE(
  idCliente Number(15) PRIMARY KEY,
  nome Varchar2(1000),
  dtaNascto Date,
  tempoFidelidade Number(15),
  idFidelidade Number(15),
  
  FOREIGN KEY (idFidelidade) REFERENCES FIDELIDADE (idFidelidade)
)


/*
Vamos adicionar uma chave estrangeira de vendendor em produto. Nesse relacionamento devemos
ter uma classes de Venda, que ir� receber o id do produto e do vendedor e a quantidade de produtos vendidos
*/

CREATE TABLE VENDA(
 idVenda Number(15) PRIMARY KEY,
 idCliente Number(15),
 dtaVenda Date,
 
 FOREIGN KEY (idCliente) REFERENCES CLIENTE (idCliente)
)

CREATE TABLE VENDAITEM(
  idVendaItem Number(15) PRIMARY KEY,
  idVenda Number(15),
  idProduto Number(15),
  quantidade Number(15),
  vlrProduto Number(8,2),
  
  FOREIGN KEY (idVenda) REFERENCES VENDA (idVenda),
  FOREIGN KEY (idProduto) REFERENCES PRODUTO (idProduto)
)
  
/*
Vamos adicionar mais detalhes ao cliente fidelizado, adicione as informa��es de endere�o a 
entidade de Cliente Fidelizado. Devemos ter a informa��o do logradouro do cliente, numero, estado e cidade.
*/

CREATE TABLE ENDCLIENTE(
  idCliente Number(15),
  logradouro Varchar(1000),
  numero Number(15),
  estado Char(2),
  cidade varchar2(1000),
  
  FOREIGN KEY (idCliente) REFERENCES CLIENTE (idCliente)
)

/*
Crie agora uma entidade Loja e uma Entidade Gerente

A Loja deve receber um gerente e agora os funcion�rios v�o ter a FK da Loja.
O Gerente deve herdar do Funcion�rio e deve ter um valor de bonus como atributo, esse bonus � por vendas realizadas no m�s, por exemplo: 1000.
*/
  
CREATE TABLE GERENTE(
  

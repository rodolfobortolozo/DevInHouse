/*
Vamos criar um sistema para o gerenciamento de uma Loja, cada exercício a seguir é parte do desenvolvimento do modelo conceitual desse sistema.

A loja deve ter vários produtos, cada produto tem um código que deve identificar o produto. Todos os produtos devem ter preço. O produto também deve possibilitar a entrada de um nome para o produto.
*/


CREATE TABLE Produto(
  idProduto Number(15) PRIMARY KEY,
  descricao Varchar2(1000),
  vlrVenda Number(15,2)
)


/*
O sistema também deve ter uma forma de guardar os funcionários, esses devem ter o nome, um identificador, salário base, e o CPF desse funcionário.

Lembrando que o campo salário deve ser numérico com 8 casas de unidade e 2 casas decimais.
*/

CREATE TABLE Funcionario(
  idFuncionario Number(15) PRIMARY KEY,
  nome Varchar(1000),
  cpf Number(15),
  VlrSalario Number(8,2)
)

/*
Devemos guardar os clientes fidelizados, esses também devem ter um nome, um identificador, data de nascimento, tempo de fidelização, bônus de fidelidade.
Ele também deve ter o nível de fidelidade:
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
ter uma classes de Venda, que irá receber o id do produto e do vendedor e a quantidade de produtos vendidos
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
Vamos adicionar mais detalhes ao cliente fidelizado, adicione as informações de endereço a 
entidade de Cliente Fidelizado. Devemos ter a informação do logradouro do cliente, numero, estado e cidade.
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

A Loja deve receber um gerente e agora os funcionários vão ter a FK da Loja.
O Gerente deve herdar do Funcionário e deve ter um valor de bonus como atributo, esse bonus é por vendas realizadas no mês, por exemplo: 1000.
*/
  
CREATE TABLE GERENTE(
  

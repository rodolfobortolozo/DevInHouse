<html>
<head>
<title>Cadastrando...</title>
</head>

<body>

<?
require 'config.php';
require 'conexao.php';
require 'database.php';

$nome=$_POST['nome'];
$departamento=$_POST['departamento'];

$query = ("INSERT INTO usuarios(nome, departamento) VALUES('$nome', '$departamento')");

DBExecute($query);
echo "Cadastrado!";
?>
<Pre>


<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>
</pre>
</body>
</html>

<html>
<head>
<title>Registrando...</title>
<meta http-equiv="refresh" content="2;url=../projeto/entradas.php">
</head>

<body>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';

//$link = DBConnect();

$id=$_POST['id'];
//echo $id;
$query = ("SELECT * FROM usuarios WHERE ID=" . $id);
//echo $query;
$result = DBExecute($query);

while($resultF = mysqli_fetch_array($result))
{
	echo '<br>';
	echo "ID: " .$resultF['id'];
	echo '<br>';
	echo "Nome: " .$resultF['nome'];
	$nome=$resultF['nome'];
	echo '<br>';
	echo "Departamento: " .$resultF['departamento'];
	$departamento=$resultF['departamento'];
	echo '<br>';
	if($resultF['status'] == 0){
		echo "Status: Inapto";
		echo '<br>';
		echo '<h1>';
		echo "NÃO AUTORIZADO!";
		echo '</h1>';
	}
	else{
		echo "Status: Apto";
		echo '<br>';
		echo "Entrada Permitida";
		echo '<br>';
		echo "Data: ";
		echo date("Y/m/d"); 
		echo "Hora: ";
		echo date("H:i"); 
		$data = date("Y/m/d");
		$hora = date("H:i");
		$query = ("INSERT INTO relatorio(id, nome, departamento, data, hora) VALUES('$id', '$nome', '$departamento', '$data', '$hora')");
		//echo $query;
		DBExecute($query);
	}	
	echo '<br>';	
}
?>
<Pre>

<a href="../projeto/entradas.php">Nova Entrada</a>

<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>
</pre>
</body>
</html>

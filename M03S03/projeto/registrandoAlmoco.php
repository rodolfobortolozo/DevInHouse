<html>
<head>
<title>Registrando Entrada para o Almoço</title>
<meta http-equiv="refresh" content="0.8;url=../projeto/entradaAlmoco.php">
</head>

<body>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';

$id=$_POST['id'];
$data = date("Y/m/d");
$hora = date("H:i");
$almoco = 1;
$janta = 0;
$jaAlmocou=0;
$query1 = ("SELECT * FROM programacao WHERE ID=" . $id . " && data = \"" .$data ."\"");
//echo $query1;
$result1 = DBExecute($query1);

while($resultF = mysqli_fetch_array($result1))
{
	$almoco = $resultF['almoco'];
}


			$query3 = ("SELECT * FROM relatorio WHERE ID=" . $id . " && tipo=\"a\" && data = \"" .$data ."\"");
			$result3 = DBExecute($query3);
			while($resultado3 = mysqli_fetch_array($result3))
			{
			$jaAlmocou=1;
			}
	if ($jaAlmocou == 0){		
		echo '<h1>';
		echo "Está autorizado";
		echo '</h1>';
		$query2 = ("SELECT * FROM usuarios WHERE ID=" . $id);
		$result2 = DBExecute($query2);
			while($resultado = mysqli_fetch_array($result2))
			{
			echo '<br>';
			echo "ID: " .$resultado['id'];
			echo '<br>';
			echo "Nome: " .$resultado['nome'];
			$nome = $resultado['nome'];
			echo '<br>';
			echo "Departamento: " .$resultado['departamento'];
			$departamento=$resultado['departamento'];
			echo '<br>';
			echo "Data: ";
			echo date("Y/m/d"); 
			echo '<br>';
			echo "Hora: ";
			echo date("H:i"); 
			$tipo = "a";
			$query3 = ("INSERT INTO relatorio(id, nome, departamento, data, hora, tipo) VALUES('$id', '$nome', '$departamento', '$data', '$hora', '$tipo')");
			//echo $query3;
			DBExecute($query3);
			$jaAlmocou=1;
			echo '<br>';	
			}
		} else{
		echo '<h1>';
		echo '<font color="red">';
		echo "Já almoçou hoje";
		echo '</font>';
		echo '</h1>';
		}
$query9 = ("INSERT INTO programacao(id, data, almoco, janta) VALUES('$id', '$data', '$almoco', '$janta')");
				DBExecute($query9);
				//echo "Cadastrado";
?>
<Pre>

<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>
</pre>
</body>
</html>

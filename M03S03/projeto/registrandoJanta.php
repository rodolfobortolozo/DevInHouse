<html>
<head>
<title>Registrando Entrada para a Janta</title>
<meta http-equiv="refresh" content="0.8;url=../projeto/entradaJanta.php">
</head>

<body>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';

$id=$_POST['id'];
$data = date("Y/m/d");
$hora = date("H:i");
$janta = 1;
$almoco = 0;
$jaJantou=0;
$query1 = ("SELECT * FROM programacao WHERE ID=" . $id . " && data = \"" .$data ."\"");
//echo $query1;
$result1 = DBExecute($query1);

while($resultF = mysqli_fetch_array($result1))
{
	$janta = $resultF['janta'];
}


		$query4 = ("SELECT * FROM relatorio WHERE ID=" . $id . " && tipo=\"j\" && data = \"" .$data ."\"");
		//echo $query4;
		$result4 = DBExecute($query4);
		while($resultado4 = mysqli_fetch_array($result4))
		{
		$jaJantou=1;
		}
			if ($jaJantou == 0){	
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
				echo "Hora: ";
				echo date("H:i"); 
				$tipo = "j";
				$query3 = ("INSERT INTO relatorio(id, nome, departamento, data, hora, tipo) VALUES('$id', '$nome', '$departamento', '$data', '$hora', '$tipo')");
				//echo $query3;
				DBExecute($query3);
				echo '<br>';
				}
			}else{
			echo '<h1>';
			echo '<font color="red">';
			echo "Já jantou hoje";
			echo '</font>';
			echo '</h1>';
			}
	
$query9 = ("INSERT INTO programacao(id, data, almoco, janta) VALUES('$id', '$data', '$almoco', '$janta')");
				DBExecute($query9);
				//echo "Cadastrado";
?>
<Pre>

<a href="../projeto/entradas.php">Nova Entrada</a>

<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>
</pre>
</body>
</html>

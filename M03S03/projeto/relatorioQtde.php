<html>

<head>
<title> Relatorio </title>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
</head>

<body>
<PRE>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';
//$query = ("SELECT * FROM `relatorio` WHERE `data` = \"2016/02/29\""); //refeicoes por dia
//$query = ("SELECT * FROM relatorio ORDER BY data, hora"); // todas as refeicoes
//$query = ("SELECT * FROM `relatorio` WHERE `data` like \"2016/02/%\""); // todas as refeições do mes
// $query = ("SELECT * FROM `relatorio` WHERE `data` like \"2016/02/%\" GROUP BY nome"); // agrupa por nome
$query = ("SELECT `nome`, COUNT(`nome`) AS total FROM `relatorio` GROUP BY `nome`"); 


//echo $query;
$result = DBExecute($query);
?>
<table border="2" width="75%">
<th>Nome</th>
<th>Departamento</th>
<th>Data</th>
<th>Hora</th>
<?
/*while($resultF = mysqli_fetch_array($result))
{
	echo '<tr>';
	echo '<td>';
	//echo "ID: " .$resultF['id'];
	//echo '<br>';
	echo $resultF['nome'];
	echo '</td>';
	echo '<td>';
	echo $resultF['departamento'];
	echo '</td>';
	echo '<td>';
	echo $resultF['data'];
	echo '</td>';
	echo '<td>';
	echo $resultF['hora'];
	echo '</td>';
	echo '</tr>';
}*/

while($resultF = mysqli_fetch_array($result))
{
	echo '<tr>';
	echo '<td>';
	//echo "ID: " .$resultF['id'];
	//echo '<br>';
	echo $resultF['nome'];
	echo '</td>';
	echo '<td>';
	echo $resultF['total'];
	echo '</td>';
	echo '</tr>';
}


?>

</table>

<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>
</PRE>
</body>


</html>
<html>

<head>
<title> Relatorio </title>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--Aqui começa os códigos para ordenar a tabela em tempo de execução clicando no cabeçalho-->
<!--Importante adicionar o id na tabela que deseja ordenar, além do thead e tbody-->
<script type="text/javascript" src="jquery.js"></script> 
<script type="text/javascript" src="jquery.tablesorter.js"></script> 
<script type="text/javascript">
	$(function() {		
		$("#tablesorter-imasters").tablesorter();
		$("#tablesorter-imasters3").tablesorter();
		
	});	
	</script>
<!--Fim do Script-->
</head>

<body>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';

$dia=$_POST['dia'];
$mes=$_POST['mes'];
$ano=$_POST['ano'];
$query = ("SELECT * FROM `relatorio` WHERE `data` like \"" .$ano."/" .$mes ."/" .$dia ."\""); // todas as refeições do dia
$result = DBExecute($query);
$almoco=0;
$janta=0;
?>
<div id="tabela">
<table border="2" width="75%" id="tablesorter-imasters3">
<thead>
<th>ID</th>
<th>Nome</th>
<th>Departamento</th>
<th>Data</th>
<th>Hora</th>
<th>Tipo</th>
</thead>
<tbody>
<?
while($resultF = mysqli_fetch_array($result))
{
	echo '<tr>';
	echo '<td>';
	echo $resultF['id'];
	echo '</td>';
	echo '<td>';
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
	echo '<td>';
	$tipo = $resultF['tipo'];
	if($tipo == "a"){
		echo "Almoço";
		$almoco = $almoco+1;
	}else{
		echo "Janta";
		$janta = $janta+1;
	}
	echo '</td>';
	echo '</tr>';
}
echo '</tbody></table>';

echo '<table><tr bgcolor=grey><td>';
	echo "Quantidade de Almoços: ";
	echo '</td><td id="total" colspan=4>';
	echo $almoco;
	echo '</td></tr>';
	echo '<tr bgcolor=grey><td>';
	echo "Quantidade de Jantas: ";
	echo '</td><td id="total" colspan=4>';
	echo $janta;
	echo '</td></tr></table>';
?>
</tbody>
</table>
</div>
<div id="imprimir" class="botao">
	<a href="#" onClick="window.print();"><div id="botoes">
		<p><img src="../projeto/print.png" /></p><p>[Imprimir]</p>
	</div></a>
	<a href="../projeto/refeitorio.php"><div id="botoes">
		<p><img src="../projeto/home.png" /></p><p>[Home]</p>
	</div></a>
</div>
</body>
</html>
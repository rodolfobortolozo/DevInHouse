<html>

<head>
<title> Relatorio Presença x Programação </title>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--Aqui começa os códigos para ordenar a tabela em tempo de execução clicando no cabeçalho-->
<!--Importante adicionar o id na tabela que deseja ordenar, além do thead e tbody-->
<script type="text/javascript" src="jquery.js"></script> 
<script type="text/javascript" src="jquery.tablesorter.js"></script> 
<script type="text/javascript">
	$(function() {		
		$("#tablesorter-imasters").tablesorter();
		$("#tablesorter-imasters2").tablesorter();
		
	});	
	</script>
<!--Fim do Script-->
</head>

<body>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';

$ano=$_POST['ano'];
$mes=$_POST['mes'];
$dia=$_POST['dia'];
$ausente="s";
$contA=0;
$contJ=0;
$progA=0;
$progJ=0;
?>
<div id="tabela">
<table border="2" width="75%" id="tablesorter-imasters">
<thead>
<th>Id</th>
<th>Nome</th>
<th>Departamento</th>
<th>Data Programada</th>
</thead>
<tbody>
<?
$query = ("SELECT * FROM `programacao` WHERE `data` like \"" .$ano. "/" .$mes ."/" .$dia ."\" && `almoco`=\"1\""); // todas as refeições programadas do dia
$result = DBExecute($query);
while($resultado = mysqli_fetch_array($result))
{
$progA = $progA +1;
	$id = $resultado['id'];
			$query2 = ("SELECT * FROM `usuarios` WHERE `id`=" .$id);
			$result2 = DBExecute($query2);
			while($resultado2 = mysqli_fetch_array($result2))
			{
			$nome = $resultado2['nome'];
			$departamento = $resultado2['departamento'];
			break;
			}
	$data= $resultado['data'];
	$almoco = $resultado['almoco'];
				$query3 = ("SELECT `id`, `tipo` FROM `relatorio` WHERE `data` like \"" .$data ."\" && `tipo`=\"a\" && `id`=" .$id); 
				$result3 = DBExecute($query3);
				if (mysqli_num_rows($result3) >0)
{
				
} else {
				$contA = $contA + 1;
				echo '<tr>';
				echo '<td>';
				echo $id;
				echo '</td>';
				echo '<td>';
				echo $nome;
				echo '</td>';
				echo '<td>';
				echo $departamento;
				echo '</td>';
				echo '<td>';
				echo $data;
				echo '</td>';
				echo '</tr>';
}
			 
					
}
				echo '</tbody></table>';
				echo '<table border="1">';
				echo '<tr><td>';
					echo "Total de Ausências no Almoço: ";
				echo '</td>';
				echo '<td>';
				echo $contA;
				echo '</td>';
				echo '</tr>';
				echo '</table>';
?>
</div>
<div id="tabela">
<table border="2" width="75%" id="tablesorter-imasters2">
<thead>
<th>Id</th>
<th>Nome</th>
<th>Departamento</th>
<th>Data Programada</th>
</thead>
<tbody>

<?
$query = ("SELECT * FROM `programacao` WHERE `data` like \"".$ano. "/" .$mes ."/" .$dia ."\" && `janta`=\"1\""); // todas as refeições programadas do dia
$result = DBExecute($query);
while($resultado = mysqli_fetch_array($result))
{
$progJ = $progJ +1;
	$id = $resultado['id'];
			$query2 = ("SELECT * FROM `usuarios` WHERE `id`=" .$id);
			$result2 = DBExecute($query2);
			while($resultado2 = mysqli_fetch_array($result2))
			{
			$nome = $resultado2['nome'];
			$departamento = $resultado2['departamento'];
			break;
			}
	$data= $resultado['data'];
	$almoco = $resultado['almoco'];
				$query3 = ("SELECT `id`, `tipo` FROM `relatorio` WHERE `data` like \"" .$data ."\" && `tipo`=\"j\" && `id`=" .$id); 
				$result3 = DBExecute($query3);
				if (mysqli_num_rows($result3) >0)
{
				
} else {
				$contJ = $contJ + 1;
				echo '<tr>';
				echo '<td>';
				echo $id;
				echo '</td>';
				echo '<td>';
				echo $nome;
				echo '</td>';
				echo '<td>';
				echo $departamento;
				echo '</td>';
				echo '<td>';
				echo $data;
				echo '</td>';
				echo '</tr>';
}
				 
					
}
				echo '</tbody></table>';
				echo '<table border="1"><tr>';
				echo '<td>';
				echo "Total de Ausências no Janta: ";
				echo '</td>';
				echo '<td>';
				echo $contJ;
				echo '</td>';
				echo '</tr></table>';

//echo "Quantidade Almoço Programado: " .$progA;
//echo "Quantidade Janta Programada: " .$progJ;				
				?>
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
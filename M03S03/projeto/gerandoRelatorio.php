<html>
<head>
<title>Gerando Relat�rio Programa��o do Dia</title>
</head>

<body>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';

$dia=$_POST['dia'];
$mes=$_POST['mes'];
$totalAlmoco=0;
$totalJanta=0;
$data = "2016/" .$mes ."/" .$dia;

$query = ("SELECT `data`, `almoco`, `janta` FROM `programacao` WHERE `data` like \"" .$data ."\" "); 
$result=DBExecute($query);
?>

<?

while($resultF = mysqli_fetch_array($result))
{	
	if($resultF['almoco'] == 1){
	$totalAlmoco ++;}
	if($resultF['janta'] == 1){
	$totalJanta ++;
	}	
}
echo $data;
echo '<p>';
echo "Total de almo�o:" .$totalAlmoco;
echo '<p>';
echo "Total de Janta:" .$totalJanta;
echo '<p>';
?>


<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>

</body>
</html>

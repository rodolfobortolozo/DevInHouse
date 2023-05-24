<html>
<head>
<title>Cadastrando Dia</title>
<meta http-equiv="refresh" content="2;url=../projeto/refeitorio.php">
</head>

<body>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';

$id=$_POST['id'];
$dia=$_POST['dia'];
$mes=$_POST['mes'];
$ano=$_POST['ano'];
$janta=$_POST['janta'];
$almoco=$_POST['almoco'];
$resposta="naoexiste";
$data = $ano ."/" .$mes ."/" .$dia;

$query3=("SELECT `id` FROM `usuarios` WHERE `id`=" .$id); 
$result3=DBExecute($query3);
$existeId = NULL;
while($resultado3 = mysqli_fetch_array($result3))
{
	$existeId = $resultado3['id'];	
}
if ($existeId == NULL) {
		echo "Esse ID ainda não foi cadastrado.";
	} else{
		//echo "Esse ID existe.";
			$query1=("SELECT `cod`, `id`, `data` FROM `programacao` WHERE `id`=" .$id); 
			$result1=DBExecute($query1);

			while($resultado = mysqli_fetch_array($result1))
			{
				$cod = $resultado['cod'];
				$idbanco = $resultado['id'];
				$databanco = $resultado['data'];
					if($id == $idbanco && $data == $databanco){
					$resposta="jaexiste";
					$query3 = ("UPDATE `programacao` SET `data` = \"" .$data ."\", `almoco` = \"" .$almoco ."\", `janta`= \"" .$janta ."\" WHERE `cod`=" .$cod);
					DBExecute($query3);
					break;
					} 
			}
			if($resposta == "jaexiste"){
				echo "Cadastro atualizado";
			}else{
				$query2 = ("INSERT INTO programacao(id, data, almoco, janta) VALUES('$id', '$data', '$almoco', '$janta')");
				DBExecute($query2);
				echo "Cadastrado";
			}	
		}
?>


</body>
</html>

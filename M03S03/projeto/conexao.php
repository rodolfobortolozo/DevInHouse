<?
// Fechando conexão com o banco
function DBClose($link){
	@mysqli_close($link) or die(mysqli_error($link));
//echo "DESCONECTADO";
	}

// abrindo conexão com o banco
function DBConnect(){
	$link	=	mysqli_connect(DB_HOSTNAME, DB_USERNAME, DB_PASSWORD, DB_DATABASE) or die(mysqli_connect_error());
//echo "CONECTADO";
return $link;
	}
?>
<html>

<head>
<title> Registrar Entrada para Almo�o</title>
<meta http-equiv="refresh" content="60">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
</head>

<body>


<?php

date_default_timezone_set('America/Sao_Paulo'); // IMPORTANTE! Faz o PHP pegar o timezone, caso n�o utilize isto, ele receber� o hor�rio do meridiano
$hora = date('Hi'); // Aqui ele pega a hora (H) e minutos (i) sem formata��o. Ex: 1850 (18:50)

if($hora <= '1430' && $hora >= '1130'){

include('../projeto/entradaAlmoco.php');


}else{

include('../projeto/entradaJanta.php');

}
 ?>




</body>


</html>
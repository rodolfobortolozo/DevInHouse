<html>
 <head>
  <title> Interface </title> 
  <link rel="stylesheet" href="style.css" type="text/css" media="all" />
 </head>

    <frameset cols="20%,*">
<?
//Recebe dados da SESSION
session_start();
if (!isset($_SESSION['id'])){
	echo "Favor fazer Login Novamente";
}else{
$tipo = $_SESSION['tipo'] ;
// session_destroy();
}
if($tipo=="Admin"){
	echo '<frame src="menuAdm.php" name="menu"></frame>';
}else{
	echo '<frame src="menu.php" name="menu"></frame>';
	}
?>       
        <frame src="" name="conteudo"></frame>
    </frameset>

</html>
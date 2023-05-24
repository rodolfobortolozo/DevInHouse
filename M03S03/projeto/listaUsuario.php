<html>

<head>
<title> Lista Usuarios </title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
</head>

<body>
<PRE>
<?
require 'config.php';
require 'conexao.php';
require 'database.php';
$query = ("SELECT * FROM usuarios ORDER BY id");
$result = DBExecute($query);
?>
<table border="2" width="75%">
<th>ID</th>
<th>Nome</th>
<th>Departamento</th>
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
	echo '</tr>';
}
echo '<P>';
?>
<div id="quadro">
<img src="../projeto/logo.svg">
Digite o ID que deseja alterar:
<form name="qual-id" id="qual-id" method="post" onsubmit="validaForm(); return false;" action="alteraDados.php">
ID: <input type="text" id="id" name="id" />

<input type="submit" value="Confirmar" />
</form>
<script type="text/javascript">
        function validaForm()
        {
            erro = false;
            if($('#id').val() == '')
            {
                alert('Você precisa preencher o campo ID');erro = true;
            }
            
            
            //se nao tiver erros
            if(!erro)
            {
                $('#qual-id').submit();
            }
        }
    </script>
<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>
</div>
</PRE>
</body>


</html>
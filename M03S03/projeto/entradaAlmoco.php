<html>

<head>
<title> Registrar Entrada para Almo�o</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
</head>

<style type="text/css"> 
body { 
background-repeat: no-repeat; 
background-position: center center; 
background-image: url(""); 
} 
</style> 

<body>

<div id="quadro">
<img src="../projeto/logo.svg">
<h1>Registrar Entrada para o Almo�o:</h1>
<form id="qual-id" name="qual-id" method="post" onsubmit="validaForm(); return false;" action="registrandoAlmoco.php">
ID: <input type="text" id="id" name="id" autofocus/>

<input class="submit" type="submit" value="Confirmar" />
</form>
<script type="text/javascript">
        function validaForm()
        {
            erro = false;
            if($('#id').val() == '')
            {
                alert('Voc� precisa preencher o campo ID');erro = true;
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
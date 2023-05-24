<html>

<head>
<title> Cadastro </title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
</head>

<body>
<div id="quadro">
<img src="../projeto/logo.svg">
<form name="form-cadastro" id="form-cadastro" method="post" onsubmit="validaForm(); return false;" action="cadastrando.php" />
Nome: <input type="text" id="nome" name="nome" />
<?/*<input type="text" id="departamento" name="departamento" />*/?><br>
<p>Departamento: 
<select name="departamento">
<option selected>Estudante
<option>Professor

</select> </p>
<input type="submit" value="Cadastrar" />
</form>
<script type="text/javascript">
        function validaForm()
        {
            erro = false;
            if($('#nome').val() == '')
            {
                alert('Você precisa preencher o campo Nome');erro = true;
            }
            if($('#departamento').val() == '' && !erro)
            {
                alert('Você precisa preencher o campo Departamento');erro = true;
            }
           
            
            //se nao tiver erros
            if(!erro)
            {
                $('#form-cadastro').submit();
            }
        }
    </script>

	<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>

</div>
</body>


</html>
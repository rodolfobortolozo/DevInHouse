<html>

<head>
<title> Relatório Mensal de Presença por Usuário </title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
</head>

<body>
<?
$ano = date("Y");
?>
<div id="quadro">
<img src="../projeto/logo.svg">
<p>
<h1>Escolha o mês desejado: </h1>
<form id="qual-mes" name="qual-mes" method="post" onsubmit="validaForm(); return false;" action="gerandoRelPres.php">
<p>Mês: 
<select name="mes">
<option selected>01
<option value="02">02
<option value="03">03
<option value="04">04
<option value="05">05
<option value="06">06
<option value="07">07
<option value="08">08
<option value="09">09
<option value="10">10
<option value="11">11
<option value="12">12
</select> </p>
<p>Ano: 
<select name="ano">
<option selected><?echo $ano;?>
<option><?echo --$ano;?>
<option><?echo --$ano;?>
</select> </p>
<p>Digitar o ID: <input type="text" id="id" name="id"></p>
<input class="submit" type="submit" value="Confirmar" />
</form>
<script type="text/javascript">
        function validaForm()
        {
            erro = false;
            if($('#mes').val() == '')
            {
                alert('Você precisa preencher o campo Mês');erro = true;
            }
            erro = false;
            
            
            //se nao tiver erros
            if(!erro)
            {
                $('#qual-mes').submit();
            }
        }
    </script>


<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>
</div>
</body>


</html>
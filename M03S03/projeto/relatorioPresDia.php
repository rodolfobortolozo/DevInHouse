<html>

<head>
<title> Relatório Presença por Dia </title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" media="all" />
</head>

<body>
<?
$ano = date("Y");
?>
<div id="quadro">
<img src="../projeto/logo.svg">
<h1>Escolha o dia desejado: </h1>
<form id="qual-dia" name="qual-dia" method="post" onsubmit="validaForm(); return false;" action="gerandoRelPresDia.php">
<p>Dia: 
<select name="dia">
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
<option value="13">13
<option value="14">14
<option value="15">15
<option value="16">16
<option value="17">17
<option value="18">18
<option value="19">19
<option value="20">20
<option value="21">21
<option value="22">22
<option value="23">23
<option value="24">24
<option value="25">25
<option value="26">26
<option value="27">27
<option value="28">28
<option value="29">29
<option value="30">30
<option value="31">31
</select> </p>
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
                $('#qual-dia').submit();
            }
        }
    </script>


<a href="../projeto/refeitorio.php">Voltar ao Menu Principal</a>
</div>
</body>


</html>
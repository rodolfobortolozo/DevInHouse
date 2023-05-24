<?
// Executa Querys
function DBExecute($query){
$link = DBConnect();
$result = mysqli_query($link, $query) or die(mysqli_error($link));

DBClose($link);
return $result;
}
?>
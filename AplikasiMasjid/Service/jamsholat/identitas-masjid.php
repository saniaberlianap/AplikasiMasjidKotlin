<?php

include("config.php");



$sql = "SELECT * FROM identitas_masjid";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array('id_identitas' => $row['id_identitas'],
    'nama_masjid' => $row['nama_masjid'],
    'alamat_masjid' => $row['alamat_masjid']
));
}
echo json_encode(array("result" => $result));
?>



<!-- <!DOCTYPE html>
<html>
<head>
	<title>SHOLAT</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>Masjid</h2>
<table class="table1">
	<tr>
		<th>No</th>
		<th>Masjid</th>
		<th>Alamat</th>
	</tr>
<?php

include("config.php");

$sql = "SELECT * FROM identitas_masjid";
$result = array();
$query = mysqli_query($db, $sql); 

while($row = mysqli_fetch_array($query)){
	echo "
	<tr> 
		<td>".$row['id_identitas']."</td>
		<td>".$row['nama_masjid']."</td>
		<td>".$row['alamat_masjid']."</td>
	</tr>
</table>";

}
?>
</body>
</html> -->
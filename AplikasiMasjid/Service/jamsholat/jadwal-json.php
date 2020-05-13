<?php

include("config.php");



$sql = "SELECT * FROM jadwal_sholat";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array('shubuh' => $row['shubuh'],
    'dhuhur' => $row['dhuhur'],
    'ashar' => $row['ashar'],
    'maghrib' => $row['maghrib'],
    'isha' => $row['isha'],
    'dhuha' => $row['dhuha']
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
<center>
<body>
	<h2>JADWAL SHOLAT</h2>
	<table class="table1">
	<tr>
		<th>Shubuh</th>
		<th>Dhuhur</th>
		<th>Ashar</th>
		<th>Maghrib</th>
		<th>Isya'</th>
	</tr>
<?php

include("config.php");

$sql = "SELECT * FROM jadwal_sholat";
$result = array();
$query = mysqli_query($db, $sql); 

while($row = mysqli_fetch_array($query)){
	echo "
	<tr> 
		<td>".$row['shubuh']."</td>
		<td>".$row['dhuhur']."</td>
		<td>".$row['ashar']."</td>
		<td>".$row['maghrib']."</td>
		<td>".$row['isha']."</td>
	</tr>
</table>";

}

?>
<p><br>

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

<p> <br>

<h2>MARQUEE</h2>
<table class="table1">
	<tr>
		<th>Marquee</th>
	</tr>
<?php

include("config.php");

$sql = "SELECT * FROM marquee";
$result = array();
$query = mysqli_query($db, $sql); 

while($row = mysqli_fetch_array($query)){
	echo "
	<tr> 
		<td>".$row['isi_marquee']."</td>
	</tr>
</table>";

}
?>


<p><br>

<h2>PENGUMUMAN</h2>
<table class="table1">
	<tr>
		<th>No</th>
		<th>Judul</th>
		<th>Isi</th>
		<th>Aktif</th>
	</tr>
<?php

include("config.php");

$sql = "SELECT * FROM pengumuman_masjid";
$result = array();
$query = mysqli_query($db, $sql); 

while($row = mysqli_fetch_array($query)){
	echo "
	<tr> 
		<td>".$row['id_pengumuman']."</td>
		<td>".$row['judul_pengumuman']."</td>
		<td>".$row['isi_pengumuman']."</td>
		<td>".$row['aktif']."</td>
	</tr>
</table>";

}
?>

<p><br>

<h2>SLIDESHOW</h2>
<table class="table1">
	<tr>
		<th>No</th>
		<th>Judul</th>
		<th>Gambar</th>
	</tr>
<?php

include("config.php");

$sql = "SELECT * FROM slideshow";
$result = array();
$query = mysqli_query($db, $sql); 

while($row = mysqli_fetch_array($query)){
	echo "
	<tr> 
		<td>".$row['id_slideshow']."</td>
		<td>".$row['judul_slideshow']."</td>
		<td>".$row['url_slideshow']."</td>
	</tr>
</table>";

}
?>


<p><br>

<h2>TAGLINE</h2>
<table class="table1">
	<tr>
		<th>No</th>
		<th>Isi</th>
	</tr>
<?php

include("config.php");

$sql = "SELECT * FROM tagline";
$result = array();
$query = mysqli_query($db, $sql); 

while($row = mysqli_fetch_array($query)){
	echo "
	<tr> 
		<td>".$row['id_tagline']."</td>
		<td>".$row['isi_tagline']."</td>
	</tr>
</table>";

}
?>

<p><br><p>
</center>
</body>
</html> -->
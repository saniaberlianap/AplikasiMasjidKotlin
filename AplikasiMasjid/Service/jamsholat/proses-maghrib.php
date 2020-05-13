<?php

include("config.php");

$maghrib = $_POST['maghrib'];


$sql = "UPDATE jadwal_sholat SET maghrib='$maghrib' WHERE id_jadwal = 1";

$query = mysqli_query($db, $sql);

?>
<?php

include("config.php");

$isha = $_POST['isha'];


$sql = "UPDATE jadwal_sholat SET isha='$isha' WHERE id_jadwal = 1";

$query = mysqli_query($db, $sql);

?>
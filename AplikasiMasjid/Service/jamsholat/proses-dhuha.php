<?php

include("config.php");

$dhuha = $_POST['dhuha'];


$sql = "UPDATE jadwal_sholat SET dhuha='$dhuha' WHERE id_jadwal = 1";

$query = mysqli_query($db, $sql);

?>
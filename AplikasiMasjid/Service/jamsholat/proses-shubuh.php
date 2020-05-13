<?php

include("config.php");

$shubuh = $_POST['shubuh'];


$sql = "UPDATE jadwal_sholat SET shubuh='$shubuh' WHERE id_jadwal = 1";

$query = mysqli_query($db, $sql);

?>
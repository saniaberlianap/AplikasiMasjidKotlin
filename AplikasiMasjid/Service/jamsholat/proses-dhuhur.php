<?php

include("config.php");

$dhuhur = $_POST['dhuhur'];


$sql = "UPDATE jadwal_sholat SET dhuhur='$dhuhur' WHERE id_jadwal = 1";

$query = mysqli_query($db, $sql);

?>
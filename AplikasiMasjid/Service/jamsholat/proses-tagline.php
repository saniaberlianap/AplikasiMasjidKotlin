<?php

include("config.php");

$isi_tagline= $_POST['isi_tagline'];


$sql = "UPDATE tagline SET isi_tagline='$isi_tagline' WHERE id_tagline = 1";

$query = mysqli_query($db, $sql);

?>
<?php
$conn = new mysqli("localhost","root","","dns");

$init_db_sql = "
CREATE TABLE if not exists `servers` (
    `IP` VARCHAR(21) NOT NULL , 
    `active` BOOLEAN NOT NULL DEFAULT TRUE , 
    `clients` int NOT NULL DEFAULT 0,
    PRIMARY KEY (`IP`(21)));
";
$init = mysqli_query($conn, $init_db_sql);
if($init) echo "Database initialized";
?>
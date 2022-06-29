<?php
set_error_handler(function($errno, $errstr, $errfile, $errline) {
    // error was suppressed with the @-operator
    if (0 === error_reporting()) {
        return false;
    }
    
    throw new ErrorException($errstr, 0, $errno, $errfile, $errline);
});

$conn = new mysqli("localhost","root","","dns");
if(isset($_GET['s'])){
    $service = $_GET['s'];
    switch ($service) {
        case 'start':
            $ip = $_GET['ip'];
            $sql = "SELECT * FROM `servers` WHERE `IP` = '".$ip."'";
            $q = mysqli_query($conn, $sql);
            $exists = mysqli_num_rows($q);
            if($exists == 1){ // If server already exist activate it
                $data = mysqli_fetch_row($q);
                $sql = "UPDATE `servers` SET `active` = 1, `clients` = 0 WHERE `IP` = '".$ip."'";
                $q = mysqli_query($conn, $sql);
                
            }else{ // If not add it to list of servers
                $sql = "INSERT INTO `servers` (`IP`) VALUES ('".$ip."')";
                $q = mysqli_query($conn, $sql);
            }
            echo "Server activated";
            break;
        case 'end':
            $ip = $_GET['ip'];
            $sql = "SELECT * FROM `servers` WHERE `IP` = '".$ip."'";
            $q = mysqli_query($conn, $sql);
            $exists = mysqli_num_rows($q);
            if($exists == 1){
                $sql = "UPDATE `servers` SET `active` = 0, `clients` = 0 WHERE `IP` = '".$ip."'";
                $q = mysqli_query($conn, $sql);
            }
            echo "Server deactivated";
            break;
        case 'clost':
            $ip = $_GET['ip'];
            $sql = "UPDATE `servers` SET `clients` = `clients` - 1 WHERE `IP` = '".$ip."'";
            $q = mysqli_query($conn, $sql);
            echo "Clients disconnected";
            break;
        case 'get':
            $sql = "SELECT * FROM `servers` WHERE `active` = 1 ORDER BY `clients`";
            $query = mysqli_query($conn, $sql);
            $exists = mysqli_num_rows($query);
            $flag = false;
            if($exists > 0){
                while($server = mysqli_fetch_row($query)){
                    $server_data = explode(":",$server[0]);
                    $host  = $server_data[0];
                    $port = $server_data[1];
                    try {
                        $socket = socket_create(AF_INET, SOCK_STREAM, 0);
                        $result = socket_connect($socket, $host, $port);
                        echo $server[0];
                        $flag = true;
                        $sql = "UPDATE `servers` SET `clients` = `clients` + 1 WHERE `IP` = '".$server[0]."'";
                        $q = mysqli_query($conn, $sql);
                        break;
                        socket_close($server_socket);
                    } catch (ErrorException $th) {
                        $sql = "UPDATE `servers` SET `active` = 0, `clients` = 0 WHERE `IP` = '".$server[0]."'";
                        $q = mysqli_query($conn, $sql);
                        continue;
                    }
                }
            }
            if(!$flag){
                echo "null";
            }
            break;
    }
}

?>
<?php

namespace App\Controllers;


require __DIR__ . '/../vendor/autoload.php';

$userController = new UserController();

header('Content-Type: application/json');
echo json_encode($userController->index());


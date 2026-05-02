CREATE DATABASE IF NOT EXISTS sistema_login;

USE sistema_login;

CREATE TABLE usuario (
id_usuario INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255),
login VARCHAR(45), 
senha VARCHAR(45),
ultimo_acesso DATETIME,
tipo ENUM('admin', 'cliente')
);

CREATE TABLE perfil (
id_perfil INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255),
ativo ENUM('s', 'n')
);
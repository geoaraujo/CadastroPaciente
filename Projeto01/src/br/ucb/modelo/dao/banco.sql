CREATE DATABASE hospital;
USE hospital;
CREATE TABLE paciente (
 id int(10) unsigned NOT NULL AUTO_INCREMENT,
 nome varchar(50) NOT NULL,
 cpf int(11) unsigned NOT NULL,
 email varchar(50) NOT NULL,
 telefone int(11) unsigned NOT NULL,
 sexo char unsigned NOT NULL,
 PRIMARY KEY (id)
)
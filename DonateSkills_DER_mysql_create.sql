CREATE TABLE `categoria` (
	`id_categoria` INT NOT NULL AUTO_INCREMENT,
	`tipo_curso` varchar(70) NOT NULL,
	PRIMARY KEY (`id_categoria`)
);

CREATE TABLE `produto` (
	`id_produto` INT NOT NULL AUTO_INCREMENT,
	`nome_curso` varchar(70) NOT NULL,
	`descricao` TEXT NOT NULL,
	`custo_monitoria` INT NOT NULL,
	`ganho_aula` INT NOT NULL,
	`ganho_prova` INT NOT NULL,
	`fk_id_categoria` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id_produto`)
);

CREATE TABLE `usuario` (
	`id_usuario` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(70) NOT NULL,
	`email` varchar(70) NOT NULL,
	`senha` varchar(70) NOT NULL,
	`pontuacao` INT NOT NULL,
	`curso_estudado` TEXT NOT NULL,
	`curso_monitorado` TEXT NOT NULL,
	`fk_id_tipo_usuario` TEXT NOT NULL,
	`curso_criado` TEXT NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `produto` ADD CONSTRAINT `produto_fk0` FOREIGN KEY (`fk_id_categoria`) REFERENCES `categoria`(`id_categoria`);

ALTER TABLE `usuario` ADD CONSTRAINT `usuario_fk0` FOREIGN KEY (`curso_estudado`) REFERENCES `produto`(`id_produto`);

ALTER TABLE `usuario` ADD CONSTRAINT `usuario_fk1` FOREIGN KEY (`curso_monitorado`) REFERENCES `produto`(`id_produto`);

ALTER TABLE `usuario` ADD CONSTRAINT `usuario_fk2` FOREIGN KEY (`fk_id_tipo_usuario`) REFERENCES `tipo_usuario`(`id_tipo_usuario`);

ALTER TABLE `usuario` ADD CONSTRAINT `usuario_fk3` FOREIGN KEY (`curso_criado`) REFERENCES `produto`(`id_produto`);


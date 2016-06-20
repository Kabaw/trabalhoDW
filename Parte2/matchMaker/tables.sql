create table usuario(
	id serial primary key,
	login varchar(40) unique,
	senha varchar(40),
	nome varchar(20),
	sobrenome varchar(20),
	email varchar(20),
	sexo varchar(1),
	dataNascimento timestamp
);

create table mensagem(
	id serial primary key,
	conteudo varchar(1024),
	remetente integer references usuario(id),
	destinatario integer references usuario(id),
	dataMensagem timestamp,
	titulo varchar(80)
);

create table grupo(
	id serial primary key,
	nome varchar(20)
);

create table usuariogrupo(
	idusuario integer references usuario(id),
	idgrupo integer references grupo(id)
);

create table jogo(
	id serial primary key,
	nome varchar(20)
);

create table amizade(
	idusuario integer references usuario(id),
	amigode integer references usuario(id)
);

create table usuariojogo(
	idusuario integer references usuario(id),
	idjogo integer references jogo(id)
);


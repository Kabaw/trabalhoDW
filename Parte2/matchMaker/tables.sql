create table usuario(
	idUsuario serial primary key,
	login varchar(40) unique not null,
	senha varchar(40) not null,
	nome varchar(20) not null,
	sobrenome varchar(20) not null,
	email varchar(20) not null,
	sexo varchar(1) not null,
	dataNascimento timestamp not null
);

create table mensagem(
	idMensagem serial primary key,
	conteudo varchar(1024) not null,
	remetente integer references usuario(idUsuario) not null,
	destinatario integer references usuario(idUsuario) not null,
	dataMensagem timestamp not null,
	titulo varchar(80)
);

create table grupo(
	idGrupo serial primary key,
	nome varchar(20) not null
);

create table usuariogrupo(
	idusuario integer references usuario(idUsuario),
	idgrupo integer references grupo(idGrupo)
);

create table jogo(
	idJogo serial primary key,
	nome varchar(20) not null
);


create table usuariojogo(
	idusuario integer references usuario(idUsuario),
	idjogo integer references jogo(idJogo)
);


select * from usuario;

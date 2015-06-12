create table if not exists feira_de_curso.curso (+
                        "codCurso int unsigned not null auto_increment," +
                        "nome varchar(80),"
                    + " turno varchar(15)," +
                        "primary key (codCurso)" +
                        ")" ;
                
create table if not exists feira_de_curso.convidado (
                      codCurso int unsigned not null,
                      nome varchar(80) not null,
                      cpf varchar (15) not null,
                      email varchar(90),
                      escolaridade varchar(20),
                      telefone varchar(15),
                      celular varchar(16),
                        foreign key (codCurso) references feira_de_curso.curso (codCurso),
                        primary key (cpf)
                        );
 load data local infile 'c:\\banco.txt' into table feira_de_curso.curso;

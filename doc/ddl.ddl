-- Generated by Oracle SQL Developer Data Modeler 4.1.5.907
--   at:        2017-03-09 09:57:32 WET
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g




CREATE TABLE ENDERECO
  (
    idEnd      NUMBER (3) NOT NULL ,
    rua        VARCHAR2 (100) NOT NULL ,
    codPostal  VARCHAR2 (8) NOT NULL ,
    lote       VARCHAR2 (10) ,
    andar      VARCHAR2 (5) ,
    localidade VARCHAR2 (30) NOT NULL
  ) ;
COMMENT ON COLUMN ENDERECO.idEnd
IS
  'id de um endere�o' ;
  COMMENT ON COLUMN ENDERECO.rua
IS
  'rua do endere�o' ;
  COMMENT ON COLUMN ENDERECO.codPostal
IS
  'codigo postal' ;
  COMMENT ON COLUMN ENDERECO.lote
IS
  'lote do endere�o' ;
  COMMENT ON COLUMN ENDERECO.andar
IS
  'andar do endere�o' ;
  COMMENT ON COLUMN ENDERECO.localidade
IS
  'localidade do endere�o' ;
ALTER TABLE ENDERECO ADD CONSTRAINT ENDERECO_PK PRIMARY KEY ( idEnd ) ;


CREATE TABLE REGISTO
  (
    idMat  VARCHAR2 (10) NOT NULL ,
    codEmp NUMBER (3) NOT NULL ,
    nome   VARCHAR2(50)
    NOT NULL ,
    apelido VARCHAR2(50)
    NOT NULL ,
    dataNasc DATE NOT NULL ,
    email    VARCHAR2 (50) ,
    idEnd    NUMBER (3) NOT NULL
  ) ;
COMMENT ON COLUMN REGISTO.idMat
IS
  'id da matricula' ;
  COMMENT ON COLUMN REGISTO.codEmp
IS
  'C�digo do empregado' ;
  COMMENT ON COLUMN REGISTO.nome
IS
  'primeiro nome do aluno' ;
  COMMENT ON COLUMN REGISTO.apelido
IS
  'apelido do aluno' ;
  COMMENT ON COLUMN REGISTO.dataNasc
IS
  'data nascimento aluno' ;
  COMMENT ON COLUMN REGISTO.idEnd
IS
  'chave estrangeira endereco' ;
ALTER TABLE REGISTO ADD CONSTRAINT REGISTO_PK PRIMARY KEY ( idMat ) ;


ALTER TABLE REGISTO ADD CONSTRAINT REGISTO_ENDERECO_FK FOREIGN KEY ( idEnd ) REFERENCES ENDERECO ( idEnd ) ;


-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             2
-- CREATE INDEX                             0
-- ALTER TABLE                              3
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   2
-- WARNINGS                                 0

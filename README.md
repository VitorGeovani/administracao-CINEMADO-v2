<div align="center">
  <img src="https://github.com/VitorGeovani/administracao-CINEMADO/assets/71882193/f95b1f9b-0ba8-4596-ab9f-0634b430e543" width="200px" />
</div>

<h1 align="center">Cinemado - Administração</h1>

<h3 align="center">:bookmark_tabs: Aplicação Java para a Administração do Festival fictício de cinema de Gramado (Cinemado)  </h3>

<div align="center">
 <img src="https://img.shields.io/badge/Java-ED8B00?style=&logo=openjdk&logoColor=white" />
 <img src="https://img.shields.io/github/repo-size/VitorGeovani/administracao-CINEMADO">
 <img src="https://img.shields.io/github/last-commit/VitorGeovani/administracao-CINEMADO">
 <img src="https://img.shields.io/github/forks/VitorGeovani/administracao-CINEMADO" />
 </div>

 <br>
 
 ## <a name="SobreoProjeto"></a>:information_source: Especificações do Projeto
 O Cinemado - Administração é um projeto inspirado em outro projeto da matéria de Programação Web do curso de TADS do SENAC - SP, que permite aos funcionários cadastrados no banco de dados, gerenciar e controlar a inserção, alteração ou exclusão de algum filme, ingresso ou evento do festival. O objetivo desta aplicação é facilitar a vida dos funcionários no controle geral do conteúdo presente no Festival Cinemado.
 <br>

## <a name="SobreoProjeto"></a>:pushpin: Funcionalidades
    - Cadastrar novos funcionários dentro do sistema;
    - Fazer login e obter acesso ao sistema;
    - Submeter filmes ao catálogo, além de Editar, Listar ou Excluir algum filme.
    - Avaliar os filmes do catálogo, adicionando uma nota de Cinematografia, Originalidade e um Comentário Técnico. Permitindo também Editar, Listar ou Excluir alguma avaliação;
    - Criar Programações com base nos filmes em catálogo, especificando Nome do filme, Diretor, Data, Horário e Local da sessão. Permitindo também Editar, Listar ou Excluir alguma programação;
    - Gerar Ingressos com base nas Programações criadas, especificando Nome do filme, Diretor, Data, Horário, Local da sessão e quantidade de Vagas Disponíveis;
    - Criar Eventos Paralelos ou dentro do festival, aumentando ainda mais o leque de opções ao público;
    
## <a name="SobreoProjeto"></a>:computer: Como Usar
    1. Abra o Apache NetBeans e execute o Project (projetopi).
    2. Cadastra-se no sistema, após cadastrar-se, faça Login no sistema.
    3. Submeta um filme ao catálogo, após submeter, será possível Avaliar, Programar ou gerar algum Ingresso para esse filme.
    4. Escolha suas ações dentro da aplicação.
    5. Continue mexendo ou encerre a aplicação.

 ## <a name="RecursosUtilizadosNesteProjeto"></a>⚒ Recursos utilizados neste projeto
<table align="center">
<th><h3>Linguagem</h3></th>
 <th><h3>IDE</h3></th>
    <th><h3>Banco de Dados</h3></th>
  <tr>
      <td valign="top" align="center">
      <a href="https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR"><img height="100" width="100" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" style="max-width:100%;"></img></a>
      </td>
   <td valign="top" align="center">
      <a href="https://netbeans.apache.org/front/main/download/"><img height="100" width="100" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Apache_NetBeans_Logo.svg/444px-Apache_NetBeans_Logo.svg.png" style="max-width:100%;"></img></a>
      </td>
      <td valign="top" align="center">
      <a href="https://dev.mysql.com/downloads/workbench/"><img height="100" width="100" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original-wordmark.svg" style="max-width:100%;"></img></a>
      </td>
    
  </tr>
</table>

## <a name="ComoContribuirParaOProjeto"></a>Como contribuir para o projeto ⁉️

1. Faça um **fork** do projeto.
2. Crie uma nova branch com as suas alterações: `git checkout -b my-feature`
3. Salve as alterações e crie uma mensagem de commit contando o que você fez: `git commit -m "feature: My new feature"`
4. Envie as suas alterações: `git push origin my-feature`
> Caso tenha alguma dúvida confira este [guia de como contribuir no GitHub](https://github.com/firstcontributions/first-contributions)

<br>

## <a name="Desenvolvedores"></a> :rocket: Desenvolvedores :octocat:
<table align="center">
  <tr>
    <td align="center"><a href="https://github.com/VitorGeovani">
    <img src="https://avatars.githubusercontent.com/u/71882193?v=4" width="100px" alt="Imagem do perfil do Vitor"/>
    <br />
     <sub><b>Vitor</b></sub><br />
     </td>
    <td align="center"><a href="https://github.com/pudimpudi">
    <img src="https://avatars.githubusercontent.com/u/127544518?v=4" width="100px" alt="Imagem do perfil da Gabi"/>
    <br />
    <sub><b>Gabrielle</b></sub><br />
     </td>
 </tr>
</table>

## <a name="ComoContribuirParaOProjeto"></a>Banco de Dados :memo:

```
create table usuarios(
id_usuario int auto_increment primary key,
email varchar(100),
senha varchar(100)
);

create table filmes (
id_filme int auto_increment primary key,
capa varchar(255),
titulo varchar(255) not null,
diretor varchar(255) not null,
genero varchar(100),
duracao int,
data_lancamento varchar(50),
sinopse text,
classificacao_indicativa varchar(50),
INDEX (titulo, diretor)
);

create table programacao (
id_programa int auto_increment primary key,
fk_id_filme int,
capa varchar(255),
fk_titulo varchar (255) not null, 
fk_diretor varchar (255) not null,
data varchar(50),
horario varchar(50),
local varchar(255),
INDEX (data, horario, local),

Foreign KEY (fk_id_filme) REFERENCES filmes(id_filme),
FOREIGN KEY (fk_titulo, fk_diretor) REFERENCES filmes(titulo, diretor)
);

create table eventos (
id_evento int auto_increment primary key,
capa varchar(255),
nome varchar(255),
data varchar(50),
hora varchar(50),
local varchar(255),
descricao text
);

create table ingressos (
id_ingresso int auto_increment primary key,
fk_id_filme int,
fk_data varchar(50),
fk_horario varchar(50),
fk_local varchar(255),
vagas int,

Foreign KEY (fk_id_filme) REFERENCES filmes(id_filme),
FOREIGN KEY (fk_data, fk_horario, fk_local) REFERENCES programacao(data, horario, local)
);

CREATE TABLE filmes_avaliacao (
    id_avaliacao INT AUTO_INCREMENT PRIMARY KEY,
    fk_id_filme INT,
    cinematografia VARCHAR(100),
    originalidade VARCHAR(100),
    comentario_tecnico TEXT,
    
    FOREIGN KEY (fk_id_filme) REFERENCES filmes(id_filme)
);

```
    
<div align="center">
  <sub><b>© 2024 Cinemado - Administração</b></sub>
</div>

[![Build Status](https://www.travis-ci.org/danielgutknecht/ponto-online-api.svg?branch=master)](https://www.travis-ci.org/danielgutknecht/ponto-online-api)
<!-- #######  YAY, I AM THE SOURCE EDITOR! #########-->
<h1 style="color: #2e6c80;"><span style="color: #000000;">API Rest Ponto Online</span></h1>
<p><span style="color: #000000;">The Ponto Online api rest is an application built with Spring Boot, Java 8, Spring Data JPA, PostgreSQL database, handling exceptions and errors, hateoas, JUnit and Mockito for unit test and integration test run in H2 memory database</span>.</p>
<h2 style="color: #2e6c80;"><span style="color: #000000;">Tecnologias utilizadas:</span></h2>
<ul>
<li><span style="color: #000000;">Spring Boot 2 e Java 8</span></li>
<li><span style="color: #000000;">Spring Data JPA</span></li>
<li><span style="color: #000000;">PostgreSQL</span></li>
<li><span style="color: #000000;">Testes unit&aacute;rios e de integra&ccedil;&atilde;o com JUnit e Mockito</span></li>
<li><span style="color: #000000;">Hateos</span></li>
<li><span style="color: #000000;">Handling exceptions and errors</span></li>
</ul>
<h2 style="color: #2e6c80;"><span style="color: #000000;">Endpoints</span></h2>
<table style="width: 610.167px; margin-left: auto; margin-right: auto;"><caption>&nbsp;</caption>
<thead>
<tr>
<th style="width: 99px; text-align: center;"><span style="color: #000000;">Empresa</span></th>
<th style="width: 10px;" align="center">&nbsp;</th>
<th style="width: 44.1667px;" align="center">&nbsp;</th>
</tr>
<tr>
<th style="width: 99px;">&nbsp;</th>
<th style="width: 10px;" align="center">&nbsp;</th>
<th style="width: 44.1667px;" align="center">&nbsp;</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;"><span style="color: #000000;">/api/v1/empresas</span></th>
<th style="width: 10px;" align="center"><span style="color: #000000;">POST</span></th>
<th style="width: 44.1667px;" align="center"><span style="color: #000000;">Cadastrar </span></th>
</tr>
<tr>
<th style="width: 99px; text-align: left;"><span style="color: #000000;">/api/v1/empresas/cnpj/{cnpj}</span></th>
<th style="width: 10px;" align="center"><span style="color: #000000;">GET</span></th>
<th style="width: 44.1667px;" align="center"><span style="color: #000000;">Buscar por CNPJ</span></th>
</tr>
<tr>
<th style="width: 99px; text-align: left;"><span style="color: #000000;">/api/v1/empresas</span></th>
<th style="width: 10px;" align="center"><span style="color: #000000;">GET</span></th>
<th style="width: 44.1667px;" align="center"><span style="color: #000000;">Listar todas empresa</span></th>
</tr>
<tr>
<th style="width: 99px; text-align: left;"><span style="color: #000000;">/api/v1/empresas/{id}</span></th>
<th style="width: 10px;" align="center"><span style="color: #000000;">DELETE</span></th>
<th style="width: 44.1667px;" align="center"><span style="color: #000000;">Excluir por id</span></th>
</tr>
<tr>
<th style="width: 99px;">&nbsp;</th>
<th style="width: 10px;" align="center">&nbsp;</th>
<th style="width: 44.1667px;" align="center">&nbsp;</th>
</tr>
<tr>
<th style="width: 99px;"><span style="color: #000000;">Funcion&aacute;rio</span></th>
<th style="width: 10px;" align="center">&nbsp;</th>
<th style="width: 44.1667px;" align="center">&nbsp;</th>
</tr>
<tr>
<th style="width: 99px;">&nbsp;</th>
<th style="width: 10px;" align="center">&nbsp;</th>
<th style="width: 44.1667px;" align="center">&nbsp;</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/funcionarios&nbsp;</th>
<th style="width: 10px;" align="center">POST</th>
<th style="width: 44.1667px;" align="center">Cadastrar</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/funcionarios/{id}</th>
<th style="width: 10px;" align="center">GET</th>
<th style="width: 44.1667px;" align="center">Buscar por id</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/funcionarios/cpf/</th>
<th style="width: 10px;" align="center">GET</th>
<th style="width: 44.1667px;" align="center">Buscar por CPF</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/v1/funcionarios/email/</th>
<th style="width: 10px;" align="center">GET</th>
<th style="width: 44.1667px;" align="center">Buscar por e-mail</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/funcionarios</th>
<th style="width: 10px;" align="center">GET</th>
<th style="width: 44.1667px;" align="center">Listar todos os funcion&aacute;rios</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/funcionarios/{id}</th>
<th style="width: 10px;" align="center">PUT</th>
<th style="width: 44.1667px;" align="center">Atualizar</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">&nbsp;</th>
<th style="width: 10px;" align="center">&nbsp;</th>
<th style="width: 44.1667px;" align="center">&nbsp;</th>
</tr>
<tr>
<th style="width: 99px; text-align: center;">Lan&ccedil;amento</th>
<th style="width: 10px;" align="center">&nbsp;</th>
<th style="width: 44.1667px;" align="center">&nbsp;</th>
</tr>
<tr>
<th style="width: 99px; text-align: center;">&nbsp;</th>
<th style="width: 10px;" align="center">&nbsp;</th>
<th style="width: 44.1667px;" align="center">&nbsp;</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/lancamentos</th>
<th style="width: 10px;" align="center">POST</th>
<th style="width: 44.1667px;" align="center">Cadastrar</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/lancamentos/{id}</th>
<th style="width: 10px;" align="center">GET</th>
<th style="width: 44.1667px;" align="center">Buscar por id</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/lancamentos/funcionario/2</th>
<th style="width: 10px;" align="center">GET</th>
<th style="width: 44.1667px;" align="center">Buscar lan&ccedil;amento por funcion&aacute;rio</th>
</tr>
<tr>
<th style="width: 99px; text-align: left;">/api/v1/lancamentos/{id}</th>
<th style="width: 10px;" align="center">PUT</th>
<th style="width: 44.1667px;" align="center">Atualizar</th>
</tr>
</thead>
</table>
<div id="readme" class="Box-body readme blob js-code-block-container px-5">&nbsp;
 
```
Give the example
```  
</div>
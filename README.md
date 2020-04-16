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
<p><span style="color: #000000;">&nbsp;</span></p>
<table>
<tbody style="font-size: 5px;">
<thead>
<tr>
<th>Empresa</th>
<th align="center">&nbsp;</th>
<th align="center">&nbsp;</th>
</tr>
<tr>
<th>&nbsp;</th>
<th align="center">&nbsp;</th>
<th align="center">&nbsp;</th>
</tr>
<tr>
<th>/api/v1/empresas</th>
<th align="center">POST</th>
<th align="center">Cadastrar</th>
</tr>
<tr>
<th>/api/v1/empresas/cnpj/{cnpj}</th>
<th align="center">GET</th>
<th align="center">Buscar por CNPJ</th>
</tr>
<tr>
<th>/api/v1/empresas</th>
<th align="center">GET</th>
<th align="center">Listar todas empresa</th>
</tr>
<tr>
<th>/api/v1/empresas/{id}</th>
<th align="center">DELETE</th>
<th align="center">Excluir por id</th>
</tr>
<tr>
<th>&nbsp;</th>
<th align="center">&nbsp;</th>
<th align="center">&nbsp;</th>
</tr>
<tr>
<th>Funcion&aacute;rio</th>
<th align="center">&nbsp;</th>
<th align="center">&nbsp;</th>
</tr>
<tr>
<th>&nbsp;</th>
<th align="center">&nbsp;</th>
<th align="center">&nbsp;</th>
</tr>
<tr>
<th>/api/v1/funcionarios&nbsp;</th>
<th align="center">POST</th>
<th align="center">Cadastrar</th>
</tr>
<tr>
<th>/api/v1/funcionarios/{id}</th>
<th align="center">GET</th>
<th align="center">Buscar por id</th>
</tr>
<tr>
<th>/api/v1/funcionarios/cpf/</th>
<th align="center">GET</th>
<th align="center">Buscar por CPF</th>
</tr>
<tr>
<th>/v1/funcionarios/email/</th>
<th align="center">GET</th>
<th align="center">Buscar por e-mail</th>
</tr>
<tr>
<th>/api/v1/funcionarios</th>
<th align="center">GET</th>
<th align="center">Listar todos os funcion&aacute;rios</th>
</tr>
<tr>
<th>/api/v1/funcionarios/{id}</th>
<th align="center">PUT</th>
<th align="center">Atualizar</th>
</tr>
<tr>
<th>&nbsp;</th>
<th align="center">&nbsp;</th>
<th align="center">&nbsp;</th>
</tr>
<tr>
<th>Lan&ccedil;amento</th>
<th align="center">&nbsp;</th>
<th align="center">&nbsp;</th>
</tr>
<tr>
<th>&nbsp;</th>
<th align="center">&nbsp;</th>
<th align="center">&nbsp;</th>
</tr>
<tr>
<th>/api/v1/lancamentos</th>
<th align="center">POST</th>
<th align="center">Cadastrar</th>
</tr>
<tr>
<th>/api/v1/lancamentos/{id}</th>
<th align="center">GET</th>
<th align="center">Buscar por id</th>
</tr>
<tr>
<th>/api/v1/lancamentos/funcionario/2</th>
<th align="center">GET</th>
<th align="center">Buscar lan&ccedil;amento por funcion&aacute;rio</th>
</tr>
<tr>
<th>/api/v1/lancamentos/{id}</th>
<th align="center">PUT</th>
<th align="center">Atualizar</th>
</tr>
</thead>
</tbody>
</table>

```
Give the example
```  
</div>
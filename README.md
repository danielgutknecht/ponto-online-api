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
<table style="height: 248px; width: 615.117px;">
<tbody>
<tr>
<td style="width: 275px;">Empresa</td>
<td style="width: 63px;">&nbsp;</td>
<td style="width: 253.117px;">&nbsp;</td>
</tr>
<tr>
<td style="width: 275px;">&nbsp;</td>
<td style="width: 63px;">&nbsp;</td>
<td style="width: 253.117px;">&nbsp;</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/empresas</td>
<td style="width: 63px; text-align: center;">POST</td>
<td style="width: 253.117px; text-align: left;">Cadastrar</td>
</tr>
<tr>
<td style="width: 275px;">api/v1/empresas/cnpj/{cnpj}</td>
<td style="width: 63px; text-align: center;">GET</td>
<td style="width: 253.117px; text-align: left;">Buscar por CNPJ</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/empresas</td>
<td style="width: 63px; text-align: center;">GET</td>
<td style="width: 253.117px; text-align: left;">Listar todas empresa</td>
</tr>
<tr>
<td style="width: 275px;">api/v1/empresas/{id}</td>
<td style="width: 63px; text-align: center;">DELETE</td>
<td style="width: 253.117px; text-align: left;">Excluir por id</td>
</tr>
<tr>
<td style="width: 275px;">&nbsp;</td>
<td style="width: 63px; text-align: center;">&nbsp;</td>
<td style="width: 253.117px; text-align: left;">&nbsp;</td>
</tr>
<tr>
<td style="width: 275px;">Funcion&aacute;rio</td>
<td style="width: 63px; text-align: center;">&nbsp;</td>
<td style="width: 253.117px; text-align: left;">&nbsp;</td>
</tr>
<tr>
<td style="width: 275px;">&nbsp;</td>
<td style="width: 63px; text-align: center;">&nbsp;</td>
<td style="width: 253.117px; text-align: left;">&nbsp;</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/funcionarios&nbsp;</td>
<td style="width: 63px; text-align: center;">POST</td>
<td style="width: 253.117px; text-align: left;">Cadastrar</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/funcionarios/{id}</td>
<td style="width: 63px; text-align: center;">GET</td>
<td style="width: 253.117px; text-align: left;">Buscar por id</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/funcionarios/cpf/</td>
<td style="width: 63px; text-align: center;">GET</td>
<td style="width: 253.117px; text-align: left;">Buscar por CPF</td>
</tr>
<tr>
<td style="width: 275px;">/v1/funcionarios/email/</td>
<td style="width: 63px; text-align: center;">GET</td>
<td style="width: 253.117px; text-align: left;">Buscar por e-mail</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/funcionarios</td>
<td style="width: 63px; text-align: center;">GET</td>
<td style="width: 253.117px; text-align: left;">Listar todos os funcion&aacute;rios</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/funcionarios/{id}</td>
<td style="width: 63px; text-align: center;">PUT</td>
<td style="width: 253.117px; text-align: left;">Atualizar</td>
</tr>
<tr>
<td style="width: 275px;">&nbsp;</td>
<td style="width: 63px; text-align: center;">&nbsp;</td>
<td style="width: 253.117px; text-align: left;">&nbsp;</td>
</tr>
<tr>
<td style="width: 275px;">Lan&ccedil;amento</td>
<td style="width: 63px; text-align: center;">&nbsp;</td>
<td style="width: 253.117px; text-align: left;">&nbsp;</td>
</tr>
<tr>
<td style="width: 275px;">&nbsp;</td>
<td style="width: 63px; text-align: center;">&nbsp;</td>
<td style="width: 253.117px; text-align: left;">&nbsp;</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/lancamentos</td>
<td style="width: 63px; text-align: center;">POST</td>
<td style="width: 253.117px; text-align: left;">Cadastrar</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/lancamentos/{id}</td>
<td style="width: 63px; text-align: center;">GET</td>
<td style="width: 253.117px; text-align: left;">Buscar por id</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/lancamentos/funcionario/{id}</td>
<td style="width: 63px; text-align: center;">GET</td>
<td style="width: 253.117px; text-align: left;">Buscar lan&ccedil;amento por funcion&aacute;rio</td>
</tr>
<tr>
<td style="width: 275px;">/api/v1/lancamentos/{id}</td>
<td style="width: 63px; text-align: center;">PUT</td>
<td style="width: 253.117px; text-align: left;">Atualizar</td>
</tr>
</tbody>
</table>

```
Give the example
```  
</div>
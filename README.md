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
<table style="height: 145px; width: 609px;">
<tbody>
<tr style="height: 2px;">
<td style="width: 273.167px; height: 2px;">Empresa</td>
<td style="width: 63.3667px; height: 2px;">&nbsp;</td>
<td style="width: 250.467px; height: 2px;">&nbsp;</td>
</tr>
<tr style="height: 2px;">
<td style="width: 273.167px; height: 2px;">/api/v1/empresas</td>
<td style="width: 63.3667px; text-align: center; height: 2px;">POST</td>
<td style="width: 250.467px; text-align: left; height: 2px;">Cadastrar</td>
</tr>
<tr style="height: 12px;">
<td style="width: 273.167px; height: 12px;">api/v1/empresas/cnpj/{cnpj}</td>
<td style="width: 63.3667px; text-align: center; height: 12px;">GET</td>
<td style="width: 250.467px; text-align: left; height: 12px;">Buscar por CNPJ</td>
</tr>
<tr style="height: 4px;">
<td style="width: 273.167px; height: 4px;">/api/v1/empresas</td>
<td style="width: 63.3667px; text-align: center; height: 4px;">GET</td>
<td style="width: 250.467px; text-align: left; height: 4px;">Listar todas empresa</td>
</tr>
<tr style="height: 18px;">
<td style="width: 273.167px; height: 18px;">api/v1/empresas/{id}</td>
<td style="width: 63.3667px; text-align: center; height: 18px;">DELETE</td>
<td style="width: 250.467px; text-align: left; height: 18px;">Excluir por id</td>
</tr>
</tbody>
</table>

```
Give the example
```  
</div>
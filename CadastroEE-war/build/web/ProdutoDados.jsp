<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Cadastro de Produto</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1><c:choose>
                <c:when test="${not empty produto}">
                    Alterar Produto
                </c:when>
                <c:otherwise>
                    Incluir Novo Produto
                </c:otherwise>
            </c:choose></h1>

        <form clas="form" action="produtos" method="post">
            <input class="form-control" type="hidden" name="acao" value="<c:choose>
                       <c:when test="${not empty produto}">alterar</c:when>
                       <c:otherwise>incluir</c:otherwise>
                   </c:choose>"/>

            <c:if test="${not empty produto}">
                <input class="form-control" type="hidden" name="id" value="${produto.id}"/>
            </c:if>
            <div class="mb-3">
                <label class="form-label" for="nome">Nome:</label>
                <input class="form-control" type="text" id="nome" name="nome" value="${not empty produto ? produto.nome : ''}" required/>
            </div>
            <div class="mb-3">
                <label class="form-label" for="quantidade">Quantidade:</label>
                <input class="form-control" type="number" id="quantidade" name="quantidade" value="${not empty produto ? produto.quantidadeEstoque : ''}" required/>
            </div>
            <div class="mb-3">
                <label class="form-label" for="preco">Preço de Venda:</label>
                <input class="form-control" type="number" step="0.01" id="preco" name="preco" value="${not empty produto ? produto.precoVenda : ''}" required/>
            </div>

            <button class="btn btn-primary" type="submit">
                <c:choose>
                    <c:when test="${not empty produto}">Alterar Produto</c:when>
                    <c:otherwise>Incluir Produto</c:otherwise>
                </c:choose>
            </button>
        </form>

        <br/>
        <a href="produtos">Voltar para a lista de produtos</a>
    </body>
</html>
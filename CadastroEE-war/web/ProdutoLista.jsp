<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="cadastroee.model.Produto" %>

<%
    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
%>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <title>Lista de Produtos</title>
        <link rel="stylesheet" href="styles.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Lista de Produtos</h1>
        <a class="btn btn-primary m-2" href="produtos?acao=formIncluir">Incluir Novo Produto</a>
        <table class="table table-striped" border="1">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Quantidade em Estoque</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (produtos != null && !produtos.isEmpty()) {
                        for (Produto produto : produtos) {
                %>
                <tr>
                    <td><%= produto.getId()%></td>
                    <td><%= produto.getNome()%></td>
                    <td><%= produto.getPrecoVenda()%></td>
                    <td><%= produto.getQuantidadeEstoque()%></td>
                    <td>
                        <a class="btn btn-primary btn-sm" href="produtos?acao=formAlterar&id=<%= produto.getId()%>">Alterar</a>
                        <a class="btn btn-danger btn-sm" href="produtos?acao=excluir&id=<%= produto.getId()%>" onclick="return confirm('Tem certeza que deseja excluir este produto?');">Excluir</a>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="5">Nenhum produto encontrado.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
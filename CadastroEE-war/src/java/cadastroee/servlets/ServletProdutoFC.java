package cadastroee.servlets;

import java.io.IOException;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/produtos"})
public class ServletProdutoFC extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade; // Referência ao EJB ProdutoFacadeLocal

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao"); // Captura o parâmetro 'acao'
        if (acao != null) {
            acao = acao.trim(); // Remove espaços em branco
        }
        System.out.println("Ação recebida: " + acao);
        String destino = null;

        if (acao == null) {
            acao = "listar";
        }

        switch (acao) {
            case "listar" -> {
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
            }
            case "formAlterar" -> {
                int idAlterar = Integer.parseInt(request.getParameter("id"));
                Produto produtoAlterar = facade.find(idAlterar);
                request.setAttribute("produto", produtoAlterar);
                destino = "ProdutoDados.jsp";
            }
            case "excluir" -> {
                int idExcluir = Integer.parseInt(request.getParameter("id"));
                Produto produtoExcluir = facade.find(idExcluir);
                facade.remove(produtoExcluir);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
            }
            case "alterar" -> {
                int idAlterarDados = Integer.parseInt(request.getParameter("id"));
                Produto produtoAlterarDados = facade.find(idAlterarDados);
                produtoAlterarDados.setNome(request.getParameter("nome"));
                produtoAlterarDados.setPrecoVenda(Float.valueOf(request.getParameter("preco")));
                produtoAlterarDados.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));
                facade.edit(produtoAlterarDados);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
            }
            case "incluir" -> {
                Produto novoProduto = new Produto();
                novoProduto.setNome(request.getParameter("nome"));
                novoProduto.setPrecoVenda(Float.valueOf(request.getParameter("preco")));
                novoProduto.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));
                facade.create(novoProduto);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
            }
            case "formIncluir" ->
                destino = "ProdutoDados.jsp";
            default -> {
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para gerenciamento de produtos";
    }
}

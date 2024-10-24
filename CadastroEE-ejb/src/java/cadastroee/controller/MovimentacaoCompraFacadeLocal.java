/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.MovimentacaoCompra;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author mathe
 */
@Local
public interface MovimentacaoCompraFacadeLocal {

    void create(MovimentacaoCompra movimentacaoCompra);

    void edit(MovimentacaoCompra movimentacaoCompra);

    void remove(MovimentacaoCompra movimentacaoCompra);

    MovimentacaoCompra find(Object id);

    List<MovimentacaoCompra> findAll();

    List<MovimentacaoCompra> findRange(int[] range);

    int count();
    
}

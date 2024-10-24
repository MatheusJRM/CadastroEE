/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.MovimentacaoVenda;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author mathe
 */
@Local
public interface MovimentacaoVendaFacadeLocal {

    void create(MovimentacaoVenda movimentacaoVenda);

    void edit(MovimentacaoVenda movimentacaoVenda);

    void remove(MovimentacaoVenda movimentacaoVenda);

    MovimentacaoVenda find(Object id);

    List<MovimentacaoVenda> findAll();

    List<MovimentacaoVenda> findRange(int[] range);

    int count();
    
}

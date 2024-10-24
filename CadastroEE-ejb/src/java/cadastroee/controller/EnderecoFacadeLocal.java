/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Endereco;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author mathe
 */
@Local
public interface EnderecoFacadeLocal {

    void create(Endereco endereco);

    void edit(Endereco endereco);

    void remove(Endereco endereco);

    Endereco find(Object id);

    List<Endereco> findAll();

    List<Endereco> findRange(int[] range);

    int count();
    
}

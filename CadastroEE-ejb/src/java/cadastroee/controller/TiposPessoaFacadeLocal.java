/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.TiposPessoa;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author mathe
 */
@Local
public interface TiposPessoaFacadeLocal {

    void create(TiposPessoa tiposPessoa);

    void edit(TiposPessoa tiposPessoa);

    void remove(TiposPessoa tiposPessoa);

    TiposPessoa find(Object id);

    List<TiposPessoa> findAll();

    List<TiposPessoa> findRange(int[] range);

    int count();
    
}

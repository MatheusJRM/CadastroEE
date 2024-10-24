/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author mathe
 */
@Entity
@Table(name = "Movimentacao_Venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimentacaoVenda.findAll", query = "SELECT m FROM MovimentacaoVenda m"),
    @NamedQuery(name = "MovimentacaoVenda.findById", query = "SELECT m FROM MovimentacaoVenda m WHERE m.id = :id"),
    @NamedQuery(name = "MovimentacaoVenda.findByQuantidadeProduto", query = "SELECT m FROM MovimentacaoVenda m WHERE m.quantidadeProduto = :quantidadeProduto"),
    @NamedQuery(name = "MovimentacaoVenda.findByValorUnitario", query = "SELECT m FROM MovimentacaoVenda m WHERE m.valorUnitario = :valorUnitario")})
public class MovimentacaoVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade_produto")
    private int quantidadeProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @JoinColumn(name = "id_pessoa_juridica", referencedColumnName = "pessoa_id")
    @ManyToOne(optional = false)
    private PessoaJuridica idPessoaJuridica;
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public MovimentacaoVenda() {
    }

    public MovimentacaoVenda(Integer id) {
        this.id = id;
    }

    public MovimentacaoVenda(Integer id, int quantidadeProduto, BigDecimal valorUnitario) {
        this.id = id;
        this.quantidadeProduto = quantidadeProduto;
        this.valorUnitario = valorUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public PessoaJuridica getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(PessoaJuridica idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentacaoVenda)) {
            return false;
        }
        MovimentacaoVenda other = (MovimentacaoVenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.MovimentacaoVenda[ id=" + id + " ]";
    }
    
}

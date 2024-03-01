package br.com.s3alugueis.app.entities.imovel;

import br.com.s3alugueis.app.entities.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_unidade_imovel")
    private UnidadeImovel unidadeImovel;
    @ManyToOne
    @JoinColumn(name = "fk_pessoa")
    private Pessoa pessoa;

    public Locacao(UnidadeImovel unidadeImovel, Pessoa pessoa) {

        this.unidadeImovel = unidadeImovel;
        if(this.unidadeImovel.isAlugada()){
            throw new IllegalArgumentException("A unidate já esta locada");
        }
        this.pessoa = pessoa;
    }
}

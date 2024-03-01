package br.com.s3alugueis.app.entities.imovel;

import br.com.s3alugueis.app.enums.imovel.TipoImovel;
import br.com.s3alugueis.app.entities.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Imovel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoImovel tipoImovel;

    private String descricao;

    private BigDecimal area;

    private BigDecimal precoAluguel;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_endereco")
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pessoa")
    private Pessoa dono;

    private String num_relogio_agua;
    private String num_relogio_luz;


}

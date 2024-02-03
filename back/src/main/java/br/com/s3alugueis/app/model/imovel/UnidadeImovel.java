package br.com.s3alugueis.app.model.imovel;

import br.com.s3alugueis.app.enums.imovel.TipoImovel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UnidadeImovel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String identificador;
    private String descricao;
    private BigDecimal area;
    private BigDecimal valor;
    private String num_relogio_agua;
    private String num_relogio_luz;
    //Terreo = 0,
    private int andar;
    @Enumerated(EnumType.STRING)
    private TipoImovel tipoImovel;

    @ManyToOne
    @JoinColumn(name="fk_imovel")
    private Imovel imovel;

    @Column(name = "alugada", nullable = false)
    private Boolean isAlugada =false;

    public Boolean isAlugada() {
        return isAlugada;
    }
}

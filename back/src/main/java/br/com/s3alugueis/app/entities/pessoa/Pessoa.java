package br.com.s3alugueis.app.entities.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pessoa_telefone",
            joinColumns = @JoinColumn(name = "pessoa_id"),
            inverseJoinColumns = @JoinColumn(name = "telefone_id")
    )
    private List<Telefone> telefones = new ArrayList<>();

}

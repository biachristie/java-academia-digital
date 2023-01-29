package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor // construtor vazio
@AllArgsConstructor // construtor com atributos
@Entity // persistência do banco de dados; pede uma chave primária
@Table(name = "tb_avaliacoes") // identifica o nome da tabela no banco de dados
public class AvaliacaoFisica {

  @Id // chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(cascade = CascadeType.ALL) // várias avaliações referentes a um aluno; cascade: o que for alterdo em avaliação física reflete em aluno
  @JoinColumn(name = "aluno_id") // a coluna das foreign keys estará na tabela da avaliação física
  private Aluno aluno;
  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();
  @Column(name = "peso_atual") // identifica o nome do atributo na coluna da tabela
  private double peso;
  @Column(name = "altura_atual")
  private double altura;

}

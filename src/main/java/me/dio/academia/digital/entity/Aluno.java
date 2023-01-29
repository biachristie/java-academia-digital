package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data // fornece getters, setters, equals e hashCode
@NoArgsConstructor // construtor vazio
@AllArgsConstructor // construtor com atributos
@Entity // injeta informação no banco de dados; pede uma chave primária
@Table(name = "tb_alunos") // identifica o nome da tabela no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

  @Id // chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamente o valor de id
  private Long id;
  private String nome;
  @Column(unique = true) // coluna com campos únicos
  private String cpf;
  private String bairro;
  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) // um aluno pode ter mais de uma avaliação física
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}

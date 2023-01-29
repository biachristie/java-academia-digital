package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor // construtor vazio
@AllArgsConstructor // construtor com atributos
@Entity // persistência do banco de dados; pede uma chave primária
@Table(name = "tb_matriculas") // identifica o nome da tabela no banco de dados
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(cascade = CascadeType.ALL) // uma matrícula está relacionada a um único aluno; cascade: o que for alterdo em matrícula reflete em aluno
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;
  private LocalDateTime dataDaMatricula = LocalDateTime.now();

}

package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByAlunoBairro(String bairro);

//    @Query("FROM Matriucla m WHERE m.aluno.bairro = :bairro")
//    List<Matricula> findAlunosMatriculadosBairro(String bairro);
//
//    @Query(value = "SELECT * FROM tb_matriculas m" +
//        "INNER JOIN tb_alunos a ON m.aluno_id = a.id" +
//        "WHERE a.bairro = :bairro", nativeQuery = true)
//    List<Matricula> findAlunosMatriculadosBairro(String bairro);
}


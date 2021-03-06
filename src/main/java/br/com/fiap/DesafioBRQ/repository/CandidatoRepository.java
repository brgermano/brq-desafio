package br.com.fiap.DesafioBRQ.repository;

import br.com.fiap.DesafioBRQ.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
    @Query(value = "select c from Candidato c where upper(trim(c.nome)) like %?1%")
    List<Candidato> findByNome(String nome);

    @Query(value = "select c from Candidato c where upper(trim(c.email)) like %?1%")
    List<Candidato> findByEmail(String email);

    @Query(value = "select c from Candidato c where upper(trim(c.cpf)) like %?1%")
    List<Candidato> findByCpf(String cpf);

    @Query(value = "select c from Candidato c where upper(trim(c.skill)) like %?1%")
    List<Candidato> findBySkill(String skill);

    @Query(value = "select c from Candidato c where upper(trim(c.certificacao)) like %?1%")
    List<Candidato> findByCertificacao(String certificacao);
}

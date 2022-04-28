package br.com.fiap.DesafioBRQ.repository;

import br.com.fiap.DesafioBRQ.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
    List<Candidato> findByNome(String cand);
    List<Candidato> findByEmail(String email);
    List<Candidato> findByCpf(String cpf);
    List<Candidato> findBySkill(String skill);
    List<Candidato> findByCertificacao(String cert);
}

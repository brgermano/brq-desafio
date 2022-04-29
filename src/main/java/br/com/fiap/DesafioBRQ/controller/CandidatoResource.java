package br.com.fiap.DesafioBRQ.controller;

import br.com.fiap.DesafioBRQ.model.Candidato;
import br.com.fiap.DesafioBRQ.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("candidato")
public class CandidatoResource {
    @Autowired
    private CandidatoRepository candidatoRepository;

    @GetMapping
    public List<Candidato> listar() { return candidatoRepository.findAll(); }

    @GetMapping("{codigo}")
    public Candidato buscar(@PathVariable int codigo) {
        return candidatoRepository.findById(codigo).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Candidato cadastrar(@RequestBody Candidato candidato) {
        return candidatoRepository.save(candidato);
    }
    @PutMapping("{id}")
    public Candidato atualizar(@RequestBody Candidato candidato, @PathVariable int id) {
        candidato.setCodigo(id);
        return candidatoRepository.save(candidato);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo) {
        candidatoRepository.deleteById(codigo);
    }

    @GetMapping(value = "buscarPorNome")
    @ResponseBody
    public ResponseEntity<List<Candidato>> buscarPorNome(@RequestParam(name = "nome") String nome) {
        List<Candidato> candidato = candidatoRepository.findByNome(nome.trim().toUpperCase());
        return new ResponseEntity<List<Candidato>>(candidato, HttpStatus.OK);
    }

    @GetMapping(value = "buscarPorEmail")
    @ResponseBody
    public ResponseEntity<List<Candidato>> buscarPorEmail(@RequestParam(name = "email") String email) {
        List<Candidato> candidato = candidatoRepository.findByEmail(email.trim().toUpperCase());
        return new ResponseEntity<List<Candidato>>(candidato, HttpStatus.OK);
    }

    @GetMapping(value = "buscarPorCpf")
    @ResponseBody
    public ResponseEntity<List<Candidato>> buscarPorCpf(@RequestParam(name = "cpf") String cpf) {
        List<Candidato> candidato = candidatoRepository.findByCpf(cpf.trim().toUpperCase());
        return new ResponseEntity<List<Candidato>>(candidato, HttpStatus.OK);
    }
    @GetMapping(value = "buscarPorSkill")
    @ResponseBody
    public ResponseEntity<List<Candidato>> buscarPorSkill(@RequestParam(name = "skill") String skill) {
        List<Candidato> candidato = candidatoRepository.findBySkill(skill.trim().toUpperCase());
        return new ResponseEntity<List<Candidato>>(candidato, HttpStatus.OK);
    }

    @GetMapping(value = "buscarPorCertificacao")
    @ResponseBody
    public ResponseEntity<List<Candidato>> buscarPorCertificacao(@RequestParam(name = "certificacao") String certificacao) {
        List<Candidato> candidato = candidatoRepository.findByCertificacao(certificacao.trim().toUpperCase());
        return new ResponseEntity<List<Candidato>>(candidato, HttpStatus.OK);
    }
}

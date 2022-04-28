package br.com.fiap.DesafioBRQ.controller;

import br.com.fiap.DesafioBRQ.model.Candidato;
import br.com.fiap.DesafioBRQ.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

}

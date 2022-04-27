package br.com.fiap.DesafioBRQ.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "candidato", sequenceName = "SQ_candidato", allocationSize = 1)
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidato")
    private int codigo;

    @NotBlank(message = "Nome obrigatório")
    @Size(max = 50)
    private String nome;

    @NotBlank(message = "CPF obrigatório")
    @Size(max = 11)
    private String cpf;

    @NotBlank(message = "Email obrigatório")
    @Size(max = 40)
    private String email;

    @NotBlank(message = "Telefone obrigatório")
    @Size(max = 11)
    private String telefone;

    @Size(max = 40)
    private String genero;

    private LocalDate dataNascimento;

    @NotBlank(message = "Skill obrigatório")
    @Size(max = 50)
    private String skill;

    @NotBlank(message = "Certificação obrigatório")
    @Size(max = 50)
    private String certificacao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCertificacao() {
        return certificacao;
    }

    public void setCertificacao(String certificacao) {
        this.certificacao = certificacao;
    }
}



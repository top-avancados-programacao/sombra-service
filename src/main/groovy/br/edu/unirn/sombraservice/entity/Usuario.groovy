package br.edu.unirn.sombraservice.entity

import com.fasterxml.jackson.annotation.JsonFormat
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.hibernate.validator.constraints.Email

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Temporal
import javax.persistence.TemporalType
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past

@Entity
@ToString
@EqualsAndHashCode(includes = ["id"])
class Usuario {

    @Id
    @GeneratedValue
    Long id

    @Email
    @Column(unique = true)
    String email

    @NotNull
    String senha

    int senhaNumerica

    @NotNull
    String telefone

    @Column(length = 200)
    String nomeCompleto

    Boolean ativo = Boolean.TRUE

    @Temporal(TemporalType.TIMESTAMP)
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date dataNascimento

    @Temporal(TemporalType.TIMESTAMP)
    Date ultimoLogin

    String hashAcesso

    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
    List<Contato> contatos = new ArrayList<>()
}

package br.edu.unirn.sombraservice.entity

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

    String senha

    int senhaNumerica

    @NotNull
    @Column(nullable = false)
    String telefone

    @Column(length = 200)
    String nomeCompleto

    Boolean ativo = Boolean.TRUE

    @Temporal(TemporalType.TIMESTAMP)
    Date dataNascimento

    @Temporal(TemporalType.TIMESTAMP)
    Date ultimoLogin

    String hashAcesso

    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
    List<Contato> contatos = new ArrayList<>()
}

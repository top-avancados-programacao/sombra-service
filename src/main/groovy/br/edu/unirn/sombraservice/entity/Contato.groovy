package br.edu.unirn.sombraservice.entity

import br.edu.unirn.sombraservice.tipo.PrioridadeContato

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Contato {

    @Id
    @GeneratedValue
    Long id

    @ManyToOne
    Usuario usuario

    @Column(nullable = false)
    String nome

    String telefone

    @Enumerated
    PrioridadeContato prioridadeContato

}

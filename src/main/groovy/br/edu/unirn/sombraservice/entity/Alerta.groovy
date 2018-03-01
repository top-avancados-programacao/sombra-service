package br.edu.unirn.sombraservice.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class Alerta {

    @Id
    @GeneratedValue
    Long id

    @ManyToOne
    Trajeto trajeto

    @Temporal(TemporalType.TIMESTAMP)
    Date dataCriacao

    @Temporal(TemporalType.TIMESTAMP)
    Date dataConclusao
}

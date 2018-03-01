package br.edu.unirn.sombraservice.entity

import br.edu.unirn.sombraservice.tipo.StatusTrajeto

import javax.persistence.Entity
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
class Trajeto {

    @Id
    @GeneratedValue
    Long id

    @ManyToOne
    Usuario usuario

    String origem
    String destino
    String ultimaLocalizacao

    @Temporal(TemporalType.TIMESTAMP)
    Date dataPartida

    @Temporal(TemporalType.TIMESTAMP)
    Date dataPrevista

    @Temporal(TemporalType.TIMESTAMP)
    Date ultimaAtualizacao

    String descricao

    @Enumerated
    StatusTrajeto statusTrajeto



}

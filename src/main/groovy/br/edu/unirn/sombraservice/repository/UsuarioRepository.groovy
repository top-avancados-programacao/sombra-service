package br.edu.unirn.sombraservice.repository

import br.edu.unirn.sombraservice.entity.Usuario
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository extends CrudRepository<Usuario,Long> {

    Usuario findByEmail(String email)

    List<Usuario> findByAtivo(Boolean ativo)

    List<Usuario> findByNomeCompletoLike(String nomeCompleto)


}
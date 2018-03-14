package br.edu.unirn.sombraservice.init

import br.edu.unirn.sombraservice.entity.Usuario
import br.edu.unirn.sombraservice.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class Bootstrap implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UsuarioRepository usuarioRepository

    @Override
    void onApplicationEvent(ApplicationReadyEvent event) {

        def usuario =
                new Usuario(email: "romulo.fagundes@gmail.com",senhaNumerica: 1234,telefone: "988855315", senha: "123")
        def usuario2 =
                new Usuario(email: "romulofc@unirn.edu.br",senhaNumerica: 1234,telefone: "988855315", senha: "123")
        usuarioRepository.save(usuario)
        usuarioRepository.save(usuario2)

        usuarioRepository.findAll().each {Usuario u->
            //println u
        }

        def usuarioRetorno = usuarioRepository.findFirstByEmail("romulo.fagundes@gmail.com")
        println "Usuario encontrado: ${usuarioRetorno.id}"

    }
}

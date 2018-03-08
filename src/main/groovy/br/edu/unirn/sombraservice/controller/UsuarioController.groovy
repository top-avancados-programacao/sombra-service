package br.edu.unirn.sombraservice.controller

import br.edu.unirn.sombraservice.entity.Usuario
import br.edu.unirn.sombraservice.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@RequestMapping("/usuario")
class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository

    @GetMapping
    List<Usuario> listar(){
        return usuarioRepository.findByAtivo(true)
    }

    @GetMapping("/{id}")
    Usuario recuperar(@PathVariable("id") Long id){
        return usuarioRepository.findOne(id)
    }

    @PostMapping("/")
    Usuario criar(@RequestBody @Valid Usuario usuario){
        return usuarioRepository.save(usuario)
    }

    @PutMapping("/{id}")
    ResponseEntity<Usuario> alterar(@PathVariable("id") Long id,@RequestBody Usuario usuario){
        def usuarioDB = usuarioRepository.findOne(id)
        if(usuarioDB){
            if(usuario.email)
                usuarioDB.email = usuario.email
            if(usuario.telefone)
                usuarioDB.telefone = usuario.telefone
            if(usuario.senha)
                usuarioDB.senha = usuario.senha
            if(usuario.dataNascimento)
                usuarioDB.dataNascimento = usuario.dataNascimento
            if(usuario.nomeCompleto)
                usuarioDB.nomeCompleto = usuario.nomeCompleto
            def usuarioSalvo = usuarioRepository.save(usuarioDB)
            return ResponseEntity.ok(usuarioSalvo)
        }else{
            return ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Usuario> remover(@PathVariable("id") Long id){
        def usuarioDB = usuarioRepository.findOne(id)
        if(usuarioDB){
            usuarioDB.ativo = false
            usuarioRepository.save(usuarioDB)
            return ResponseEntity.ok().build()
        }else{
            return ResponseEntity.notFound().build()
        }
    }

}

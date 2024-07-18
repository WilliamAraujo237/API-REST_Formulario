package com.Formulario.Formulario.Controller;

import com.Formulario.Formulario.DTO.RegistroDTO;
import com.Formulario.Formulario.Repository.RegistroRepository;
import com.Formulario.Formulario.Service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RegistroController {
    @Autowired
    RegistroRepository Repository;

    @Autowired
    private RegistroService servico;

    //Break Point para Deletar um registro
    @DeleteMapping("/Deletar/{id}")
    public void Deleta(@PathVariable Long id){
        Repository.deleteById(id);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //Break Point para recuperar todos os registros NativeQuery
    @GetMapping("/ObterRegistros")
    public ResponseEntity<?> SelectGeral(){
        return servico.ObtemRegistoros();
    }

    //Break point para buscar um registro por ID NativeQuery
    @GetMapping("/RecuperaRegistro/{id}")
    public List<RegistroDTO> RecuperaRegistroID(@PathVariable Long id){
        return Repository.SelecionaPorID(id);
    }

    //Break Point para modificar um registro NativeQuery
    @PutMapping("/Modifica")
    public @ResponseBody ResponseEntity<?> AtualizaRegistro(@RequestBody RegistroDTO registro){
        return servico.modifica(registro);
    }

    //Break Point para cadastrar um registro NativeQuery
    @PostMapping("/Registrar")
    public @ResponseBody ResponseEntity<?> cadastro(@RequestBody RegistroDTO registro ){
        return servico.cadastrar(registro);
    }
}

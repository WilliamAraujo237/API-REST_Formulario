package com.Formulario.Formulario.Service;

import com.Formulario.Formulario.DTO.RegistroDTO;
import com.Formulario.Formulario.Repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository repository;

    //Regra para registrar um novo usuário e comida na lista
    public ResponseEntity<?> cadastrar(RegistroDTO registro){
        if (registro.getNome().equals("")){
            String Mensagem = "O campo nome, não pode estar vazio";
            return new ResponseEntity<>(Mensagem, HttpStatus.BAD_REQUEST);
        } else if (registro.getDescricao().equals("")) {
            String Mensagem = "A Descrição não pode estar vazia";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        } else if (registro.getValor() < 0) {
            String Mensagem = "O campo valor não pode ser menor que 0";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(repository.InsertRegistro(registro.getNome(),registro.getDescricao(), registro.getValor(), registro.getDisponivel()), HttpStatus.OK);
        }
    }

    //Regra para modificar um registro da tabela registro_comida_colaboradordto
    public ResponseEntity<?> modifica(RegistroDTO registro){
        if (registro.getNome().equals("")){
            String Mensagem = "O campo nome, não pode estar vazio";
            return new ResponseEntity<>(Mensagem, HttpStatus.BAD_REQUEST);
        } else if (registro.getDescricao().equals("")) {
            String Mensagem = "A Descrição não pode estar vazia";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        } else if (registro.getValor() < 0) {
            String Mensagem = "O campo valor não pode ser menor que 0";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(repository.UpdateGeral(registro.getNome(),registro.getDescricao(),registro.getValor(),registro.getDisponivel(),registro.getId()),HttpStatus.OK);
        }
    }

    //Regra para obter todos os registros
    public ResponseEntity<?> ObtemRegistoros(){
        return new ResponseEntity<>(repository.SelectGeral(),HttpStatus.OK);
    }

    //Regra para Deletar um registro da tabela registro_comida_colaboradordto
    public ResponseEntity<?> DeletaRegistro(RegistroDTO registro){
        if (registro.getId() == null){
            String Mensagem = "O campo ID não pode estar vazio";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        } else if (registro.getId() < 1) {
            String Mensagem = "O campo ID não pode ser menosr que 1";
            return new ResponseEntity<>(Mensagem,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(repository.DeletaRegistro(registro.getId()),HttpStatus.OK);
    }
}

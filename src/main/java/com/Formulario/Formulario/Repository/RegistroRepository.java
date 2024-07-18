package com.Formulario.Formulario.Repository;

import com.Formulario.Formulario.DTO.RegistroDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RegistroRepository extends CrudRepository<RegistroDTO,Long> {

    @PersistenceContext
    EntityManager entityManeger = null;

    //Query para pegar todos os registros da tabela registro_comida_colaboradordto
    @Query(value = "SELECT * FROM Produtos ORDER BY Valor DESC",nativeQuery = true)
    List<RegistroDTO> SelectGeral();

    //Query para pegar um registro pelo ID
    @Query(value = "SELECT * FROM Produtos WHERE id = :id",nativeQuery = true)
    List<RegistroDTO> SelecionaPorID(Long id);



    //Query para Atualizar um registro pelo ID
    @Modifying
    @Query(value = "UPDATE Produtos SET nome=:Nome,descricao=:Descricao,valor=:Valor,disponivel=:Disponivel WHERE id=:id",nativeQuery = true)
    int UpdateGeral(String Nome,String Descricao,Double Valor,String Disponivel, Long id);


    //Query para inserir um novo registro
    @Modifying
    @Query(value = "INSERT INTO Produtos (nome,descricao,valor,disponivel) VALUES (:nome,:Descricao,:Valor,:Disponivel)",nativeQuery = true)
    int InsertRegistro(String nome,String Descricao,Double Valor,String Disponivel);

    //Query para Deletar um registro
    @Modifying
    @Query(value = "DELETE FROM Produtos WHERE id=:id",nativeQuery = true)
    Void DeletaRegistro(Long id);

}

package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    void registrar(Usuario usuario);

    List<Usuario> getUsuarios();

    void eliminar(Long id);

    Usuario verificarCredenciales(Usuario usuario);


    void modificar(Long id);
}

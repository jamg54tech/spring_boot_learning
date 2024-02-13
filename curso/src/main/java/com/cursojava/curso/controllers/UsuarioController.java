package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "usuario/{id}")
    public  Usuario getUsuario(@PathVariable Long id){
       Usuario usuario = new Usuario();

       usuario.setNombre("Jose");;
       usuario.setApellido("Molina");
       usuario.setEmail("jamgbatiz@gmail.com");
       usuario.setTelefono("5577879902");
       usuario.setId(id);

       return  usuario;
    }

    @RequestMapping(value = "api/usuario")
    public  List<Usuario> listUsuario(){
        return  usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuario2")
    public  Usuario editar(){
        Usuario usuario = new Usuario();

        usuario.setNombre("Jose");;
        usuario.setApellido("Molina");
        usuario.setEmail("jamgbatiz@gmail.com");
        usuario.setTelefono("5577879902");

        return  usuario;
    }

    @RequestMapping(value = "api/usuario/{id}",method = RequestMethod.DELETE)
    public  void eliminar(@PathVariable Long id){

        usuarioDao.eliminar(id);

        //return  null;
    }

    @RequestMapping(value = "api/usuario",method = RequestMethod.POST)
    public  void registrarUsuario(@RequestBody  Usuario usuario){
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuario/{id}",method = RequestMethod.PUT)
    public  void registrarUsuario(@PathVariable Long id){
        usuarioDao.modificar(id);
    }
}

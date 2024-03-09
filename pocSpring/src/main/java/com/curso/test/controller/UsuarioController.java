package com.curso.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.test.dao.UsuarioDao;
import com.curso.test.models.Usuario;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao<Usuario,Long> usuarioDao;
    
    @RequestMapping(value = "api/usuario/{id}")
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
    	System.out.println("LISTADO NUEVO 2");       
    	return  usuarioDao.<Usuario>getUsuariosV2();
    	
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
package com.curso.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.test.dao.UsuarioDao;
import com.curso.test.models.Usuario;
import com.curso.test.utils.JWTUtil;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao<Usuario,Long> usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado=usuarioDao.verificarCredenciales(usuario);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }
}
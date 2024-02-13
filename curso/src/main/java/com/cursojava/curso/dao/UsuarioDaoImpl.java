package com.cursojava.curso.dao;

import com.cursojava.curso.models.Usuario;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImpl implements  UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public List<Usuario> getUsuarios() {
        String query="FROM Usuario";
        List<Usuario> resultado=entityManager.createQuery(query).getResultList();
        return resultado;
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario= entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public Usuario verificarCredenciales(Usuario usuario) {
        String query="FROM Usuario where email=:email and password=:password";
        List<Usuario> resultado=entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .setParameter("password",usuario.getPassword()).
                getResultList();

        if(resultado.isEmpty()){
            return null;
        }

        return  resultado.get(0);
    }

    @Override
    public void modificar(Long id) {
        Usuario usr=entityManager.find(Usuario.class, id);
        usr.setTelefono("ACTIVE");
        entityManager.merge(usr);//implicitly flushes if flush mode is COMMIT or AUTO.
    }
}
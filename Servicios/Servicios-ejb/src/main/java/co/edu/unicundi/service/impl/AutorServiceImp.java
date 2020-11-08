/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service.impl;

import co.edu.unicundi.dto.AutorDto;
import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.Libro;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.repo.IAutor;
import co.edu.unicundi.service.IAutorService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;

/**
 *
 * @author johan
 */
@Stateless
public class AutorServiceImp implements IAutorService {

    @EJB
    private IAutor repo;

    @Override
    public List<AutorDto> listar(boolean filtro) {

        List<Autor> listaAutor = repo.listar(filtro);
        List<AutorDto> listaAutorDto = new ArrayList<>();
        for (Autor lista : listaAutor) {
            ModelMapper modelMapper = new ModelMapper();
            AutorDto autorDto = modelMapper.map(lista, AutorDto.class);
            listaAutorDto.add(autorDto);
        }
        if (filtro == false) {
            for (AutorDto aut : listaAutorDto) {
                aut.setLibro(null);
            }
        }
        return listaAutorDto;
    }

    @Override
    public Autor listarPorId(Integer id) throws ObjectNotFoundException {
        Autor autor = repo.listarPorId(id);
        if (autor == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        } else {
            return autor;
        }
    }

    @Override
    public void guardar(Autor autor) {
        if (autor.getLibro() != null) {
            for (Libro libro : autor.getLibro()) {
                libro.setAutor(autor);
            }
        }
        autor.setEstado(false);
        repo.guardar(autor);
    }

    @Override
    public void editar(Autor autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) throws ObjectNotFoundException {
        Autor autor = this.listarPorId(id);
        if(repo.buscarLibrosAutor(id) == true){
        //if(autor.getLibro().size() == 0){
            repo.eliminar(autor);
            //System.out.println("Entro a eliminar bien");
        }else{
            throw new ObjectNotFoundException("Error, hay libros correspondientes al autor. ");
        }
    }

    @Override
    public void cambiarEstado(boolean estado, int id) throws ObjectNotFoundException {
        Autor autor = repo.listarPorId(id);
        if (autor != null) {
            //repo.cambiarEstado(estado, id);
            autor.setEstado(estado);
            repo.editar(autor);
        } else {
            throw new ObjectNotFoundException("Autor no existe.");
        }
    }

    @Override
    public List<AutorDto> listarGenerico() {
        List<Autor> listaAutor = repo.listarGenerico();
        List<AutorDto> listaAutorDto = new ArrayList<>();
        for (Autor lista : listaAutor) {
            ModelMapper modelMapper = new ModelMapper();
            AutorDto autorDto = modelMapper.map(lista, AutorDto.class);
            listaAutorDto.add(autorDto);
        }
        return listaAutorDto;
    }
}

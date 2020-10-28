/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ASUS-PC
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.unicundi.controller.AutorController.class);
        resources.add(co.edu.unicundi.controller.ProfesorController.class);
        resources.add(co.edu.unicundi.controller.UsuarioController.class);
        resources.add(co.edu.unicundi.exception.filter.ConstraintViolationFilter.class);
        resources.add(co.edu.unicundi.exception.filter.ExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.NullPointerExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.ObjectNotFoundExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.ObjectRequeridExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.ParamRequiredUsedFilter.class);
        resources.add(co.edu.unicundi.exception.filter.WebApplicationFilter.class);
    }
    
}

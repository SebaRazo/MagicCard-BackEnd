package com.back.MagicCard.service;

import com.back.MagicCard.model.Admin;
import com.back.MagicCard.model.AppUser;
import com.back.MagicCard.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    public AppUser registrarUser(AppUser appUser){
        return appUserRepository.save(appUser);
    }
    //Actualizar User
    public AppUser updateUser(AppUser appUser){
        return appUserRepository.save(appUser);
    }
    public Optional<AppUser> buscarUser(Long user_id) {
        return appUserRepository.findById(user_id);
    }
    //Buscar TodosUser
    public List<AppUser> buscarTodosAdmins(){return appUserRepository.findAll();}
    //Eliminar User
    public void deleteAdmin(Long user_id) {appUserRepository.deleteById(user_id);}
}

package com.back.MagicCard.service;

import com.back.MagicCard.model.Admin;
import com.back.MagicCard.repository.AdminRepository;
import com.back.MagicCard.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    //Registrar Admin
    public Admin registrarAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    //Actualizar Admin
    public Admin updateAdmin(Admin admin){
        return adminRepository.save(admin);
    }
    public Optional<Admin> buscarAdmin(Long admin_id) {
        return adminRepository.findById(admin_id);
    }
    //Buscar TodosAdmins
    public List<Admin> buscarTodosAdmins(){return adminRepository.findAll();}
    //Eliminar Admin
    public void deleteAdmin(Long admin_id) {adminRepository.deleteById(admin_id);}

}

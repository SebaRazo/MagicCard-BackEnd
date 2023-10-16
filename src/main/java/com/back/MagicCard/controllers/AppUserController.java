package com.back.MagicCard.controllers;

import com.back.MagicCard.model.AppUser;
import com.back.MagicCard.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app-user")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    // Crear un nuevo AppUser
    @PostMapping
    public ResponseEntity<AppUser> crearAppUser(@RequestBody AppUser appUser) {
        AppUser nuevoAppUser = appUserService.registrarUser(appUser);
        return new ResponseEntity<>(nuevoAppUser, HttpStatus.CREATED);
    }

    // Actualizar AppUser existente
    @PutMapping("/{user_id}")
    public ResponseEntity<AppUser> actualizarAppUser(@PathVariable("user_id") Long userId, @RequestBody AppUser appUser) {
        Optional<AppUser> appUserExistente = appUserService.buscarUser(userId);
        if (appUserExistente.isPresent()) {
            appUser.setUser_id(userId);
            AppUser appUserActualizado = appUserService.updateUser(appUser);
            return new ResponseEntity<>(appUserActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener un AppUser por su ID
    @GetMapping("/{user_id}")
    public ResponseEntity<AppUser> obtenerAppUser(@PathVariable("user_id") Long userId) {
        Optional<AppUser> appUser = appUserService.buscarUser(userId);
        return appUser.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener todos los AppUsers
    @GetMapping
    public ResponseEntity<List<AppUser>> obtenerTodosAppUsers() {
        List<AppUser> appUsers = appUserService.buscarTodosAdmins();
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }

    // Eliminar un AppUser por su ID
    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> deleteAppUser(@PathVariable("user_id") Long userId) {
        Optional<AppUser> appUserExistente = appUserService.buscarUser(userId);
        if (appUserExistente.isPresent()) {
            appUserService.deleteAdmin(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

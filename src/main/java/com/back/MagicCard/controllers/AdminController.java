package com.back.MagicCard.controllers;

import com.back.MagicCard.model.Admin;
import com.back.MagicCard.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Crear un nuevo Admin
    @PostMapping
    public ResponseEntity<Admin> crearAdmin(@RequestBody Admin admin) {
        Admin nuevoAdmin = adminService.registrarAdmin(admin);
        return new ResponseEntity<>(nuevoAdmin, HttpStatus.CREATED);
    }

    // Actualizar Admin existente
    @PutMapping("/{admin_id}")
    public ResponseEntity<Admin> actualizarAdmin(@PathVariable("admin_id") Long adminId, @RequestBody Admin admin) {
        Optional<Admin> adminExistente = adminService.buscarAdmin(adminId);
        if (adminExistente.isPresent()) {
            admin.setAdmin_id(adminId);
            Admin adminActualizado = adminService.updateAdmin(admin);
            return new ResponseEntity<>(adminActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener un Admin por su ID
    @GetMapping("/{admin_id}")
    public ResponseEntity<Admin> obtenerAdmin(@PathVariable("admin_id") Long adminId) {
        Optional<Admin> admin = adminService.buscarAdmin(adminId);
        return admin.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener todos los Admins
    @GetMapping
    public ResponseEntity<List<Admin>> obtenerTodosAdmins() {
        List<Admin> admins = adminService.buscarTodosAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    // Eliminar un Admin por su ID
    @DeleteMapping("/{admin_id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable("admin_id") Long adminId) {
        Optional<Admin> adminExistente = adminService.buscarAdmin(adminId);
        if (adminExistente.isPresent()) {
            adminService.deleteAdmin(adminId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


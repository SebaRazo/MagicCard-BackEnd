package com.back.MagicCard.controllers;

import com.back.MagicCard.model.Seller;
import com.back.MagicCard.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    // Crear un nuevo Seller
    @PostMapping
    public ResponseEntity<Seller> crearSeller(@RequestBody Seller seller) {
        Seller nuevoSeller = sellerService.registrarSeller(seller);
        return new ResponseEntity<>(nuevoSeller, HttpStatus.CREATED);
    }

    // Actualizar Seller existente
    @PutMapping("/{seller_id}")
    public ResponseEntity<Seller> actualizarSeller(@PathVariable("seller_id") Long sellerId, @RequestBody Seller seller) {
        Optional<Seller> sellerExistente = sellerService.buscarSeller(sellerId);
        if (sellerExistente.isPresent()) {
            seller.setSeller_id(sellerId);
            Seller sellerActualizado = sellerService.updateSeller(seller);
            return new ResponseEntity<>(sellerActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener un Seller por su ID
    @GetMapping("/{seller_id}")
    public ResponseEntity<Seller> obtenerSeller(@PathVariable("seller_id") Long sellerId) {
        Optional<Seller> seller = sellerService.buscarSeller(sellerId);
        return seller.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Obtener todos los Sellers
    @GetMapping
    public ResponseEntity<List<Seller>> obtenerTodosSellers() {
        List<Seller> sellers = sellerService.buscarTodosSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    // Eliminar un Seller por su ID
    @DeleteMapping("/{seller_id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable("seller_id") Long sellerId) {
        Optional<Seller> sellerExistente = sellerService.buscarSeller(sellerId);
        if (sellerExistente.isPresent()) {
            sellerService.deleteSeller(sellerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

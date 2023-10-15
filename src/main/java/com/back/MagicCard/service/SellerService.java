package com.back.MagicCard.service;

import com.back.MagicCard.model.Admin;
import com.back.MagicCard.model.Seller;
import com.back.MagicCard.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public Seller registrarSeller(Seller seller){
        return sellerRepository.save(seller);
    }
    //Actualizar Seller
    public Seller updateSeller(Seller seller){
        return sellerRepository.save(seller);
    }
    public Optional<Seller> buscarSeller(Long seller_id) {
        return sellerRepository.findById(seller_id);
    }
    //Buscar TodosSellers
    public List<Seller> buscarTodosSellers(){return sellerRepository.findAll();}
    //Eliminar Seller
    public void deleteSeller(Long seller_id) {sellerRepository.deleteById(seller_id);}
}

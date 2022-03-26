package com.kibuh.tstestexo2.rrepositories;

import com.kibuh.tstestexo2.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produit,Long> {
}

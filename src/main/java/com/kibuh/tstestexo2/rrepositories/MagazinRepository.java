package com.kibuh.tstestexo2.rrepositories;

import com.kibuh.tstestexo2.entities.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazinRepository extends JpaRepository<Magazine,Long> {
}

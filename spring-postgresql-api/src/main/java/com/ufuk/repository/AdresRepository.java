package com.ufuk.repository;

import com.ufuk.domain.Adres;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ufukremzi
 */
public interface AdresRepository extends JpaRepository<Adres , Long> {
}

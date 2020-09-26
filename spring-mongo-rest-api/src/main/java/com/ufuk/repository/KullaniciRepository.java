package com.ufuk.repository;

import com.ufuk.domain.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author ufukremzi
 */
public interface KullaniciRepository  extends MongoRepository<Kullanici , String> {
}

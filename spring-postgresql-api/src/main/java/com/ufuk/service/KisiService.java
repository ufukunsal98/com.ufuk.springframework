package com.ufuk.service;

import com.ufuk.domain.Kisi;
import com.ufuk.rest.KisiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author ufukremzi
 */
public interface KisiService {
    KisiDto save(KisiDto kisiDto);
    void delete(KisiDto kisiDto);
    List<KisiDto> getAllKisi();
    Page<Kisi> getAll(Pageable pageable);
}

package com.ufuk.controller;

import com.ufuk.domain.Kisi;
import com.ufuk.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ufukremzi
 */
@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
@Slf4j
public class KisiController {

    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init() {
        Kisi kisi = Kisi.builder().ad("ufuk").soyad("ünsal").adres("ss")
                .dogumTarihi(new Date()).id(UUID.randomUUID().toString()).build();
        kisiRepository.save(kisi);
        log.warn("kisi eklendi...");
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        return ResponseEntity.ok(kisiRepository.getCustomQuery(search));
    }
}

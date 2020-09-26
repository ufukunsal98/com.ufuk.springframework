package com.ufuk.service;

import com.ufuk.domain.Kullanici;
import com.ufuk.repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

/**
 * @author ufukremzi
 */

@RestController
@RequestMapping("/kullanici")
@RequiredArgsConstructor
public class KullaniciService {

    private final KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init() {
        Kullanici kullanici = Kullanici.builder().adi("ufuk").soyadi("ünsal")
                .id(UUID.randomUUID().toString()).build();
        kullaniciRepository.save(kullanici);
    }

    @PostMapping
    public Kullanici ekle(@RequestBody Kullanici kullanici) {
        return kullaniciRepository.save(kullanici);
    }

    @GetMapping
    public List<Kullanici> tumunuListele() {
        return kullaniciRepository.findAll();
    }
}

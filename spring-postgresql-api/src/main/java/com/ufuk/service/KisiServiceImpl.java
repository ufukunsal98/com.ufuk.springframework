package com.ufuk.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufuk.domain.Adres;
import com.ufuk.domain.Kisi;
import com.ufuk.repository.AdresRepository;
import com.ufuk.repository.KisiRepository;
import com.ufuk.rest.KisiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author ufukremzi
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

//    @PostConstruct
//    public void init() {
//        Adres adres = new Adres().builder().adres("şentepe polatli").adresTip(Adres.AdresTip.EV_ADRESI).aktif(true).build();
//        Kisi kisi = Kisi.builder().adi("ufuk remzi").soyadi("ünsal").id(1L).build();
//        adres.setKisi(kisi);
//        Adres adresDB = adresRepository.save(adres);
//        kisi.setAdresleri(List.of(adresDB));
//        kisiRepository.save(kisi);
//        log.warn("Kisi ve adres eklendi...");
//    }

    @Override
    public KisiDto save(KisiDto kisiDto) {
        Kisi kisi = Kisi.builder().adi(kisiDto.getAdi())
                .soyadi(kisiDto.getSoyadi())
                .id(new Random().nextLong())
                .adresList(kisiDto.getAdresleri())
                .build();
        kisi =  kisiRepository.save(kisi);
        Adres adres = Adres.builder().adresTip(
                kisiDto.getAdresleri().get(0).getAdresTip()
        ).adres(kisiDto.getAdresleri().get(0).getAdres()).kisi(kisi).build();
        adres = adresRepository.save(adres);

        return KisiDto.builder().adi(kisi.getAdi())
                .soyadi(kisi.getSoyadi())
                .id(new Random().nextLong())
                .adresleri(kisi.getAdresList())
                .build();
    }

    @Override
    public void delete(KisiDto kisiDto) {
        kisiRepository.delete(kisiRepository.findById(kisiDto.getId()).orElse(new Kisi()));
    }

    @Override
    public List<KisiDto> getAllKisi() {
        List<KisiDto> kisiDtoList = new ArrayList<>();
        List<Kisi> kisis = kisiRepository.findAll();
        kisis.stream().forEach(
                kisi -> {
                    kisiDtoList.add(KisiDto.builder().adi(kisi.getAdi())
                            .soyadi(kisi.getSoyadi())
                            .id(kisi.getId())
                            .adresleri(kisi.getAdresList())
                            .build());
                }
        );
        return kisiDtoList;
    }

    @Override
    public Page<Kisi> getAll(Pageable pageable) {
        return kisiRepository.findAll(pageable);
    }
}

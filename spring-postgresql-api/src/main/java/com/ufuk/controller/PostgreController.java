package com.ufuk.controller;

import com.ufuk.domain.Kisi;
import com.ufuk.rest.KisiDto;
import com.ufuk.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ufukremzi
 */

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PostgreController {

    private final KisiService kisiService;

    @GetMapping
    public ResponseEntity<List<KisiDto>> getAll(){
        return ResponseEntity.ok(kisiService.getAllKisi());
    }

    @PostMapping
    public ResponseEntity<KisiDto> getAll(@RequestBody KisiDto kisiDto){
        return ResponseEntity.ok(kisiService.save(kisiDto));
    }


}

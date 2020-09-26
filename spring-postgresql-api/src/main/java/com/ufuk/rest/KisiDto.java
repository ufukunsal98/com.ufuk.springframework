package com.ufuk.rest;

import com.ufuk.domain.Adres;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ufukremzi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KisiDto {

    private Long id;

    private String adi;

    private String soyadi;

    private List<Adres> adresleri;
}

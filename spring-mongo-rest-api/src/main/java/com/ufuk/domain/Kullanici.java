package com.ufuk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

/**
 * @author ufukremzi
 */

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kullanici {
    @Id
    private String id;
    private String adi;
    private String soyadi;
    private HashMap ozellikleri;
}

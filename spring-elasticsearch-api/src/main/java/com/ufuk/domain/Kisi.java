package com.ufuk.domain;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.UUID;

/**
 * @author ufukremzi
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "kisiler" , indexStoreType = "kisi")
public class Kisi {
    @Id
    private String id = UUID.randomUUID().toString();
    @Field(type = FieldType.Auto)
    private String ad;
    @Field(type = FieldType.Auto)
    private String soyad;
    @Field(type = FieldType.Auto)
    private String adres;
    @Field(type = FieldType.Auto)
    private Date dogumTarihi;
}

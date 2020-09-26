package com.ufuk.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author ufukremzi
 */

@Entity
@Table(name = "KISI")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = {"id"})
public class Kisi {

    @Id
    @SequenceGenerator(name = "seq_kisi_id" , allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_id" , strategy = GenerationType.SEQUENCE)
    private Long id;



    @Column(name = "adi" , length = 100)
    private String adi;

    @Column(name = "soyadi" , length = 100)
    private String soyadi;

    @OneToMany(mappedBy = "kisi")
    private List<Adres> adresList;
}

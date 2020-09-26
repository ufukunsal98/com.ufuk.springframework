package com.ufuk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author ufukremzi
 */

@Entity
@Table(name = "ADRES")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(of = {"id"})
public class Adres implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_kisi_adres" , allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres" , strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "adres")
    private String adres;
    @Enumerated
    @Column(name = "adresTip")
    private AdresTip adresTip;
    @Column(name = "aktif")
    private Boolean aktif;

    @ManyToOne(fetch = FetchType.LAZY) // @ManyToOne(fetch = FetchType.LAZY) -> get atılırsa getirir diğerinde direk getirir
    @JoinColumn(name = "kisi_id", nullable=false)
    @JsonIgnore
    private Kisi kisi;


    public enum AdresTip {
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }
}

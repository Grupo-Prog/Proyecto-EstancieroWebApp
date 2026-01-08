package com.estanciero.api.domain.entities.boxes;

import com.estanciero.api.domain.entities.Player;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("PROPERTY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyBox extends Box {

    //provincia a la que pertenece
    private String provinceName;

    //precio de compra base
    private Double purchasePrice;
    //precio de renta base
    private Double rentValue;

    private Integer chacrasCount;
    private Boolean hasEstancia;
    //esta hipotecado?
    private Boolean isMortgage;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Player owner;
}

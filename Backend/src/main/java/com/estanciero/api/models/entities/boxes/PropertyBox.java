package com.estanciero.api.models.entities.boxes;

import com.estanciero.api.models.entities.Player;
import com.estanciero.api.models.enums.PropertyType;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    //provincia a la que pertenece
    private String provinceName;

    //precio de compra base
    private Double purchasePrice;
    //precio de renta base
    private Double rentValue;

    //de 0 a 4
    private Integer chacrasCount;
    private Boolean hasEstancia = false;
    //esta hipotecado?
    private Boolean isMortgage = false;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Player owner;
}

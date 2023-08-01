package com.example.Fproject.database.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "[manager]")
public class Manager {
    @Schema(description = "The id of the manager, composed of letters and numbers.", example = "frank")
    //@schema屬性描述
    @Id
    //@id:primary key
    private String managerId;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

}

package com.example.Fproject.database.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "[manager]")
public class Manager {
    @Schema(description = "The id of the manager, composed of several numbers.", example = "000003")
    //@schema屬性描述
    @Id
    //@id:primary key
    private String managerId;

    @Schema(description = "The id of the manager, composed of letters and numbers.",example = "frank")
    @Column
    private String manager;

    @ManyToOne(targetEntity = Device.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id", referencedColumnName = "deviceId")
    private Device device;

    public member toMember(){
        return new member(getManager());
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class member{
        @Schema(description = "The id of the manager, composed of letters and numbers.",example = "frank")
        private String manager;
    }
}


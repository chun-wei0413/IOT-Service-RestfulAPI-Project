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
@Table(name = "[device]")
public class Device {
    @Schema(description = "The id of the device, composed of three numbers.", example = "001")
    @Id
    private String deviceId;
    @Schema(description = "The type of the device,consists of letters.",example = "user")
    @Column
    private String type;
    @Schema(description = "the pin consists of letters and numbers",example = "GPIO03")
    @Column
    private String pin;


    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Set<UserDevice> userDevices = new HashSet<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private Set<Manager> manager = new HashSet<>();

    public Data toData(){
        return new Data(getDeviceId(),getType());
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data{
        @Schema(description = "The id of the device, composed of three numbers.", example = "001")
        private String deviceId;
        @Schema(description = "The type of the device,consists of letters.",example = "user")
        private String type;
    }

}

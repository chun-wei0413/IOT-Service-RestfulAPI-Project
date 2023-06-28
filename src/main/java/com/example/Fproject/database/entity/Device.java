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
    @Schema(description = "The url of the device",example = "http://XXX")
    @Column
    private String url;

    @Schema(description = "The type of the device,consists of letters.",example = "user")
    @Column
    private String type;
    @Schema(description = "the pin consists of letters and numbers",example = "GPIO03")
    @Column
    private String pin;
    @Schema(description = "the manager of the device,if the value is 0 it means a general user and 1 means the device manager.",example = "1")
    @Column
    private String manager;

    @ManyToMany(mappedBy = "device")
    private Set<User> user = new HashSet<User>();
}

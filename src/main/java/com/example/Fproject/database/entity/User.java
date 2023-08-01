package com.example.Fproject.database.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.example.Fproject.database.entity.Device;
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
@Table(name = "[user]")
public class User {
    @Schema(description = "The id of the user, composed of letters and numbers.", example = "frank")
    //@schema屬性描述
    @Id
    //@id:primary key
    private String userId;
    @Schema(description = "User can set their own password for authentication,which is consists of 6 digits of letters and numbers.",example = "23RDW5")
    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserDevice> userDevices = new HashSet<>();


}
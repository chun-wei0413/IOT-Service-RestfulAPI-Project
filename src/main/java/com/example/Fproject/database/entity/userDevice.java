package com.example.Fproject.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class userDevice {
    @ManyToMany
    @Id
    @JoinColumn(name="user_id_fk",referencedColumnName = "userId")
    private user user;

    @ManyToMany
    @Id
    @JoinColumn(name="device_id_fk",referencedColumnName ="deviceId")
    private device device;
}

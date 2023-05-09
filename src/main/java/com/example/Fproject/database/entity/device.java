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
@Table(name = "[device]")
public class device {
    @Schema(description = "The id of the device, composed of three numbers.", example = "001")
    @Id
    private String id;
    @Schema(description = "The url of the device",example = "http://XXX")
    @Column
    private String url;
    @Schema(description = "the key of authentication, Consists of six random capital letters and numbers",example = "23RDW5")
    @Column
    private String apiKey;

}

package com.example.Fproject.apibody;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
public class IotBean {
    @Getter
    @Setter
    public static class AddDeviceBean{
        @Schema(description = "The url of Iot device", example = "https://34b2-2402-7500-586-e710-25f3-3d9-cc89-63f0.ngrok-free.app/")
        @NotEmpty
        private String url;
        @Schema(description = "", example = "Check if the device belongs to the group")
        @NotEmpty
        private String isGroup;
    }
}

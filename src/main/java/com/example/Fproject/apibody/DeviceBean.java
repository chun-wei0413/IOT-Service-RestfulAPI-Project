package com.example.Fproject.apibody;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public class DeviceBean {
    @Getter
    @Setter
    public static class AddDeviceBean{
        @Schema(description = "The url of Iot device", example = "https://34b2-2402-7500-586-e710-25f3-3d9-cc89-63f0.ngrok-free.app/")
        @NotEmpty
        private String url;
        @Schema(description = "The type of Iot device", example = "fan")
        @NotEmpty
        private String type;
        @Schema(description = "The pin configuration of the IOT device.", example = "14")
        @NotEmpty
        private String pin;
        @Schema(description = "The administrator of the IOT device.", example = "wqr002")
        @NotEmpty
        private String manager;
    }
    @Getter
    @Setter
    public static class AlterDeviceBean{
        @Schema(description = "The ID of user", example = "wqr002")
        @NotEmpty
        private String userId;
        @Schema(description = "The ID of Iot device", example = "002")
        @NotEmpty
        private String deviceId;
        @Schema(description = "Password consisting of six characters", example = "ssssss")
        @NotEmpty
        private String password;
        @Schema(description = "The url of Iot device", example = "https://34b2-2402-7500-586-e710-25f3-3d9-cc89-63f0.ngrok-free.app/")
        @NotEmpty
        private String url;
    }
    @Getter
    @Setter
    public static class DeleteDeviceBean{
        @Schema(description = "The ID of user", example = "wqr002")
        @NotEmpty
        private String userId;
        @Schema(description = "The ID of Iot device", example = "002")
        @NotEmpty
        private String deviceId;
        @Schema(description = "Password consisting of six characters", example = "ssssss")
        @NotEmpty
        private String password;
    }
    @Getter
    @Setter
    public static class QueryDeviceBean{
        @Schema(description = "The ID of user", example = "wqr002")
        @NotEmpty
        private String userId;
        @Schema(description = "Password consisting of six characters", example = "ssssss")
        @NotEmpty
        private String password;
    }
}

package com.example.Fproject.apibody;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public class UserBean {
    @Getter
    @Setter
    public static class DeleteUserBean{
        @Schema(description = "The ID of user", example = "wqr002")
        @NotEmpty
        private String userId;
        @Schema(description = "Password consisting of six characters", example = "ssssss")
        @NotEmpty
        private String password;
    }
    @Getter
    @Setter
    public static class AuthorUserBean{
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
    public static class RegisterUserBean{
        @Schema(description = "The ID of user", example = "wqr002")
        @NotEmpty
        private String userId;
        @Schema(description = "Password consisting of six characters", example = "ssssss")
        @NotEmpty
        private String password;
    }
}

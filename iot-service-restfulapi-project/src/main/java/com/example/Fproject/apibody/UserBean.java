package com.example.Fproject.apibody;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class UserBean implements Serializable{
    @Getter
    @Setter
    public static class DeleteUserBean {
        public DeleteUserBean(String UserId,String password){
            this.userId = UserId;
            this.password = password;
        }
        @Schema(description = "The ID of user", example = "wqr002")
        @NotEmpty
        private String userId;
        @Schema(description = "Password consisting of six characters", example = "ssssss")
        @NotEmpty
        private String password;
        public String toString() {
            return "User{" +
                    "name='" + userId + '\'' +
                    ", password='" + password +
                    "'}";
        }
    }
    @Getter
    @Setter
    public static class AuthorUserBean{
        public AuthorUserBean(String UserId,String deviceId,String password){
            this.userId = UserId;
            this.deviceId = deviceId;
            this.password = password;
        }
        @Schema(description = "The ID of user", example = "wqr002")
        @NotEmpty
        private String userId;
        @Schema(description = "The ID of Iot device", example = "002")
        @NotEmpty
        private String deviceId;
        @Schema(description = "Password consisting of six characters", example = "ssssss")
        @NotEmpty
        private String password;
        public String toString() {
            return "User{" +
                    "name='" + userId + '\'' +
                    ", deviceId='"+deviceId+'\''+
                    ", password='" + password +
                    "'}";
        }
    }
    @Getter
    @Setter
    public static class RegisterUserBean{
        public RegisterUserBean(String UserId,String password){
            this.userId = UserId;
            this.password = password;
        }
        @Schema(description = "The ID of user", example = "wqr002")
        @NotEmpty
        private String userId;
        @Schema(description = "Password consisting of six characters", example = "ssssss")
        @NotEmpty
        private String password;
        public String toString() {
            return "User{" +
                    "name='" + userId + '\'' +
                    ", password='" + password +
                    "'}";
        }
    }


}

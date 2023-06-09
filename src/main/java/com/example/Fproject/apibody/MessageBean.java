package com.example.Fproject.apibody;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageBean {
    @Schema(description = "Error description.",example = "Error description")
    @NotEmpty
    private String message;
    public static MessageBean CreateMessageBean(String message){
        return new MessageBean(message);
    }
}

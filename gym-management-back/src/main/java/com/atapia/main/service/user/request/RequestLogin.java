package com.atapia.main.service.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogin {
    @NotBlank(message = "El campo \"nameUser\" es requerido.")
    private String nameUser;
    
    @NotBlank(message = "El campo \"password\" es requerido.")
    private String password;
}

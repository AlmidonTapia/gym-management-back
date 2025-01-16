package com.atapia.main.service.user.request;


import lombok.Data;
@Data
public class RequestUpdate {
    private String idUser;
    private String nameUser;
    private String email;
    private String password;
    private String rol;
    private Boolean state;
}

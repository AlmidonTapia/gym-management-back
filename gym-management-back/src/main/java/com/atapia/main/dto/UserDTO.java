package com.atapia.main.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {
    private String idUser;
    private String nameUser;
    private String email;
    private String password;
    private String rol;
    private Boolean state;
    private Date createdAt;
    private Date updatedAt;

}

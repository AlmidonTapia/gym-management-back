package com.atapia.main.service.user.response;

import com.atapia.main.service.ResponseGeneral;

public class ResponseLogin extends ResponseGeneral {
    public class Dto{
        public Object user;
    }
    public Dto dto;
    public ResponseLogin(){
        dto=new Dto();
    }
}

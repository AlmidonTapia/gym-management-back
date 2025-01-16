package com.atapia.main.service.user.response;

import java.util.ArrayList;
import java.util.List;

import com.atapia.main.service.ResponseGeneral;

public class ResponseGetAll extends ResponseGeneral {
   public class Dto {
      public List<Object> listUser;
   }

   public Dto dto;

   public ResponseGetAll() {
      dto = new Dto();

      dto.listUser = new ArrayList<>();
   }
}

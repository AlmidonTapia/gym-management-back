package com.atapia.main.service.customer.response;

import java.util.ArrayList;
import java.util.List;

import com.atapia.main.service.ResponseGeneral;

public class ResponseGetAll extends ResponseGeneral{
public class Dto {
		public List<Object> listCustomer;
	}

	public Dto dto;

	public ResponseGetAll() {
		dto = new Dto();

		dto.listCustomer = new ArrayList<>();
	}
}

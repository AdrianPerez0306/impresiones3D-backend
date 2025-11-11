package com.mandarinaSolutions.impresiones3d.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mandarinaSolutions.impresiones3d.DTO.MailDTO;
import com.mandarinaSolutions.impresiones3d.services.MailService;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:5173", "http://localhost:5174"})

public class ControllerMail {
	
	@Autowired
	private MailService mailSender;
	
	@PostMapping("/send")
	public String sendMail(@RequestBody MailDTO request) {
		mailSender.sendMail(request);
		return "Envio exitoso";
	}
	
	
}

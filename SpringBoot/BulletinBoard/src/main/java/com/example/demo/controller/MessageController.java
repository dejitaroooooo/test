package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Message;
import com.example.demo.form.MessageForm;
import com.example.demo.service.MessageService;

@Controller
public class MessageController {
	@Autowired
	private MessageService service;

	@GetMapping("/messages")
	public String message(Model model) {
		model.addAttribute("messageForm",new MessageForm());
		List<Message> messages = service.getAll();
		model.addAttribute("messages",messages);
		System.out.println(new Timestamp(System.currentTimeMillis()));
		return "messages";
	}

	@PostMapping("/messages")
	public String messagePost(Model model, @Valid MessageForm messageForm, BindingResult bindingResult, HttpServletRequest request	) {
		if(bindingResult.hasErrors()) {
			List<Message> message = service.getAll();
			model.addAttribute("message", message);
			return "message";
		}
		System.out.println(new Timestamp(System.currentTimeMillis()));

		service.insertMessage(messageForm.getName(), messageForm.getText(), request.getRemoteAddr());

		return "redirect:/messages";
	}


}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.MessageDao;
import com.example.demo.entity.Message;

@Service
@Transactional
public class MessageService {
	@Autowired
	private MessageDao messageDao;

	public List<Message> getAll(){
		return messageDao.getAll();
	}

	public void insertMessage(String name, String text, String remoteAddr) {
		messageDao.insertMessage(name, text, remoteAddr);
	}

}

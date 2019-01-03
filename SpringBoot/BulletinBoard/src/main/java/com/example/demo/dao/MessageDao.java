package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Message;

@Repository
public class MessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Message> getAll(){
		return jdbcTemplate.query(("select * from message order by id"), new MessageRowMapper());
	}

	class MessageRowMapper implements RowMapper<Message>{
		@Override
		public Message mapRow(ResultSet rs, int rowNum) throws SQLException{
			Message message = new Message();
			message.setId(rs.getInt("id"));
			message.setName(rs.getString("name"));
			message.setText(rs.getString("text"));
			message.setRemoteAddr(rs.getString("remoteAddr"));
			message.setCreatedAt(rs.getDate("createdAt"));
			return message;
		}
	}

	public void insertMessage(String name, String text, String remoteAddr) {
		jdbcTemplate.update("insert into message(name, text, remoteAddr, createdAt) values (?,?,?,?)",
				name, text, remoteAddr,new Timestamp(System.currentTimeMillis()));
	}
}

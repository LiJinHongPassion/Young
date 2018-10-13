package com.cqut.young.ssm.entity;

import com.cqut.young.ssm.entity.base.Entity;

public class Message extends Entity {
    private String message_id;

    private String receiver_id;

    private String sender_id;

    private String message_type;

    private String message_title;

    private String message_introl;

    private String message_img_path;

    private String message_state;
    
    private String message_time;

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id == null ? null : message_id.trim();
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id == null ? null : receiver_id.trim();
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id == null ? null : sender_id.trim();
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type == null ? null : message_type.trim();
    }

    public String getMessage_title() {
        return message_title;
    }

    public void setMessage_title(String message_title) {
        this.message_title = message_title == null ? null : message_title.trim();
    }

    public String getMessage_introl() {
        return message_introl;
    }

    public void setMessage_introl(String message_introl) {
        this.message_introl = message_introl == null ? null : message_introl.trim();
    }

    public String getMessage_img_path() {
        return message_img_path;
    }

    public void setMessage_img_path(String message_img_path) {
        this.message_img_path = message_img_path == null ? null : message_img_path.trim();
    }

    public String getMessage_state() {
        return message_state;
    }

    public void setMessage_state(String message_state) {
        this.message_state = message_state == null ? null : message_state.trim();
    }

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "message";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "message_id";
	}

	public String getMessage_time() {
		return message_time;
	}

	public void setMessage_time(String message_time) {
		this.message_time = message_time;
	}
}
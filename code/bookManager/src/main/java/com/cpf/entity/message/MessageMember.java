package com.cpf.entity.message;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message_member")
public class MessageMember
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="status")
	private String status;//0:noRead 1:read
	
	@Column(name="sendType")
	private String sendType;//0:reader,1:manager
	
	@Column(name="recevierId")
	private Long recevierId;
	
	@Column(name="readTime")
	private Date readTime;
	
	@Column(name="hasDelete")
	private String hasDelete;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getSendType()
	{
		return sendType;
	}

	public void setSendType(String sendType)
	{
		this.sendType = sendType;
	}

	public Long getRecevierId()
	{
		return recevierId;
	}

	public void setRecevierId(Long recevierId)
	{
		this.recevierId = recevierId;
	}

	public Date getReadTime()
	{
		return readTime;
	}

	public void setReadTime(Date readTime)
	{
		this.readTime = readTime;
	}

	public String getHasDelete()
	{
		return hasDelete;
	}

	public void setHasDelete(String hasDelete)
	{
		this.hasDelete = hasDelete;
	}
}

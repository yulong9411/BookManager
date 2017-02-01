package com.cpf.entity.message;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message_info")
public class MessageInfo
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="content")
	private String content;
	
	@Column(name="title")
	private String title;
	
	@Column(name="createTime")
	private Date createTime;
	
	@Column(name="readNum")
	private Integer readNum;
	
	@Column(name="type")
	private String type;
	
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

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Integer getReadNum()
	{
		return readNum;
	}

	public void setReadNum(Integer readNum)
	{
		this.readNum = readNum;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
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

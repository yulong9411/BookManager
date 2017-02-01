package com.cpf.entity.info;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log_info")
public class LogInfo
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="operateTime")
	private Date operateTime;
	
	@Column(name="managerId")
	private Long managerId;
	
	@Column(name="hasDelete")
	private String hasDelete;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Date getOperateTime()
	{
		return operateTime;
	}

	public void setOperateTime(Date operateTime)
	{
		this.operateTime = operateTime;
	}

	public Long getManagerId()
	{
		return managerId;
	}

	public void setManagerId(Long managerId)
	{
		this.managerId = managerId;
	}

	public String getHasDelete()
	{
		return hasDelete;
	}

	public void setHasDelete(String hasDelete)
	{
		this.hasDelete = hasDelete;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
	
	
}

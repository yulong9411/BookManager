package com.cpf.entity.system;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="book_reader")
public class BReader
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="readerId",nullable=false)
	private String readerId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="addTime")
	private Date addTime;
	
	@Column(name="lastLogin")
	private Date lastLogin;
	
	@Column(name="hasDelete")
	private String hasDelete;
	
	@Column(name="borrowCount")
	private Integer borrowCount;
	
	@Column(name="editTime")
	private Date editTime;
	
	@JsonIgnore
	@Column(name="password")
	private String password;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}


	public String getReaderId()
	{
		return readerId;
	}

	public void setReaderId(String readerId)
	{
		this.readerId = readerId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Date getAddTime()
	{
		return addTime;
	}

	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	public Date getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin)
	{
		this.lastLogin = lastLogin;
	}

	public String getHasDelete()
	{
		return hasDelete;
	}

	public void setHasDelete(String hasDelete)
	{
		this.hasDelete = hasDelete;
	}

	public Integer getBorrowCount()
	{
		return borrowCount;
	}

	public void setBorrowCount(Integer borrowCount)
	{
		this.borrowCount = borrowCount;
	}

	public Date getEditTime()
	{
		return editTime;
	}

	public void setEditTime(Date editTime)
	{
		this.editTime = editTime;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}

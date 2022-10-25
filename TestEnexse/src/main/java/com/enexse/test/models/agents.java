package com.enexse.test.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "agents")
public class agents implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String os ;
    private java.util.Date lastKeepAlive ;
    private java.util.Date dateAdd;
    private String ip ;
    private String version ;
    private String name ;
    
    public enum Statut {
    	active,
    	disconnected,
    	pending,
    	never_connected,
        
    }

    @Enumerated(EnumType.STRING)
    private Statut status   ;

	public agents(String os, java.util.Date lastKeepAlive, java.util.Date dateAdd, String ip, String version, String name,
			Statut status) {
		super();
	
		this.os = os;
		this.lastKeepAlive = lastKeepAlive;
		this.dateAdd =  dateAdd;
		this.ip = ip;
		this.version = version;
		this.name = name;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public java.util.Date getLastKeepAlive() {
		return lastKeepAlive;
	}

	public void setLastKeepAlive(java.util.Date lastKeepAlive) {
		this.lastKeepAlive = lastKeepAlive;
	}

	public java.util.Date getDateAdd() {
		return dateAdd;
	}

	public void setDateAdd(java.util.Date dateAdd) {
		this.dateAdd = dateAdd;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Statut getStatus() {
		return status;
	}

	public void setStatus(Statut status) {
		this.status = status;
	}

	public agents(long id, String os, java.util.Date lastKeepAlive, java.util.Date dateAdd, String ip, String version,
			String name, Statut status) {
		super();
		this.id = id;
		this.os = os;
		this.lastKeepAlive = lastKeepAlive;
		this.dateAdd = dateAdd;
		this.ip = ip;
		this.version = version;
		this.name = name;
		this.status = status;
	}

	public agents() {
		super();
	}
	
	


	
	

	
    
    
   
    

}

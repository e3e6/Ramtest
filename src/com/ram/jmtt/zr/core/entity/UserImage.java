package com.ram.jmtt.zr.core.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "USER_IMAGES")
public class UserImage  implements Serializable{


	private static final long serialVersionUID = -74004400983103495L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pid")
	private Long id;

	
    @Lob
    @Column(name="data")
    @Basic(fetch = FetchType.LAZY)
    private byte[] data;

	
	public UserImage() {}

	public Long getId() {
		return id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}

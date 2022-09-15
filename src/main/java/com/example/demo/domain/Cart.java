package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable{
	
	public static final long serialVersionUID = -2228784815938588107L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

}

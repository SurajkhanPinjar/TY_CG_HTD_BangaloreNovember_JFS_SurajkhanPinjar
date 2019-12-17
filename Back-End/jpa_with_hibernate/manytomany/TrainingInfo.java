package com.cap.jpawithhibernate.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.capgemini.jpahibernate.onetoone.EmployeeInfo;

import lombok.Data;

@Entity
@Data
@Table (name = "train_info")
public class TrainingInfo {
	@Id
	@Column
	private int tid;
	@Column
	private String name;
	@Column
	private int duration;
	
	
	@javax.persistence.ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name ="train_employee",
	joinColumns = @JoinColumn(name ="tid"),
	inverseJoinColumns = @JoinColumn(name = "eid"))
	private List<EmployeeInfo> eList;
	

}

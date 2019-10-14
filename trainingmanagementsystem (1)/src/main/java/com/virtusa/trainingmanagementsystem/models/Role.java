package com.virtusa.trainingmanagementsystem.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RoleTable")
public class Role {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="RoleId")
private int roleId;

@Column(name="RoleName")
private String roleName;

@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private Employee employees;

public int getRoleId() {
	return roleId;
}

public void setRoleId(int roleId) {
	this.roleId = roleId;
}

public String getRoleName() {
	return roleName;
}

public void setRoleName(String roleName) {
	this.roleName = roleName;
}

public Employee getEmployees() {
	return employees;
}

public void setEmployees(Employee employees) {
	this.employees = employees;
}

}

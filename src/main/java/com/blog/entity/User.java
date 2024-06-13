package com.blog.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
	
	@Id
	private int id;
	private String fullName;
	private String email;
	private String userName;	
	private String password;
	@ManyToMany()
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(name="user_id" , referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "roleId")		
	)
	private Set<Role>roles;

}

package com.company.model;

import lombok.*;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
public class User {

	@Id
	@Column(name = "id", unique = true, updatable = false, nullable = false)
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "salary", nullable = false)
	private Double salary;
}

package com.hyperd.mustard.checker

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "checkers")
class Checker(
		var name: String,
		@Id @GeneratedValue var id: Long? = null)

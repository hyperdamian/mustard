package com.hyperd.mustard.checker

import com.hyperd.mustard.extractor.Extractor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "checkers")
class Checker(
		var name: String,
		@ManyToOne
		@JoinColumn(name = "extractor_id")
		var extractor: Extractor,
		@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long? = null)

package com.hyperd.mustard.extractor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "extractors")
class Extractor(
		var name: String,
		@Id @GeneratedValue var id: Long? = null)

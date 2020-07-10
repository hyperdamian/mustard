package com.hyperd.mustard.extractor

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("extractor")
class ExtractorController(val extractorService: ExtractorService) {

	@GetMapping
	fun getAll(): Iterable<Extractor> = extractorService.getAll()

	@PostMapping
	fun addExtractor(@RequestBody extractor: Extractor) = extractorService.addExtractor(extractor)

}

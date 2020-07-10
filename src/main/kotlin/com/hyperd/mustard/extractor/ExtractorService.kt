package com.hyperd.mustard.extractor

import org.springframework.stereotype.Service

@Service
class ExtractorService(val extractorRepository: ExtractorRepository) {

	fun getAll(): Iterable<Extractor> = extractorRepository.findAll()
	fun addExtractor(extractor: Extractor) = extractorRepository.save(extractor)

}

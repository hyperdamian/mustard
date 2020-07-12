package com.hyperd.mustard.extractor.handler

import org.jsoup.nodes.Document

class HmExtractorHandler : BaseExtractorHandler() {

	// TODO: price is always under the same CSS query so there should be a common class to define only such queries

	override fun extract(document: Document): String {
		val text = document.select(".price-value").text()
		document.absUrl("a")
		if (text.isEmpty()) {
			throw RuntimeException("${this.javaClass.simpleName}: price not found for URL FIXME")
		}

		return text
	}

}

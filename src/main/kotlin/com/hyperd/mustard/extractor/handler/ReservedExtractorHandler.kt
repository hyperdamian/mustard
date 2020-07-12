package com.hyperd.mustard.extractor.handler

import org.jsoup.nodes.Document

private val PRICE_REGEX = Regex("\"price\":\"(\\d+,\\d{2})\"") // "price":"49,99"

class ReservedExtractorHandler : BaseExtractorHandler() {

	override fun extract(document: Document): String {
		val select = document.select("script")
		val text = select.first { it.data().contains("dataLayer.push") }
				.data()

		val find = PRICE_REGEX.find(text)?.groups?.get(1)?.value

		if (find != null) {
			return find
		}

		throw RuntimeException("${this.javaClass.simpleName}: price not found for URL FIXME")
	}

}

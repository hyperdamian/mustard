package com.hyperd.mustard.extractor.handler

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

abstract class BaseExtractorHandler : ExtractorHandler {

	final override fun extract(url: String): String {
		return extract(Jsoup.connect(url).get())
	}

	abstract fun extract(document: Document): String

}

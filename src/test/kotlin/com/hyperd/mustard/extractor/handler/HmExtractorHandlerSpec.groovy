package com.hyperd.mustard.extractor.handler

import spock.lang.Unroll

class HmExtractorHandlerSpec extends spock.lang.Specification {

	HmExtractorHandler sut

	def setup() {
		sut = new HmExtractorHandler()
	}

	@Unroll
	def 'should parse price of #product'(String product, String url, String expected) {
		when:
		def actual = sut.extract(url)

		then:
		actual == expected

		where:
		product            | url                                                     || expected
		'discounted shirt' | 'https://www2.hm.com/pl_pl/productpage.0818059003.html' || '49,90 PLN'
		'sweatshirt'       | 'https://www2.hm.com/pl_pl/productpage.0685813028.html' || '39,99 PLN'
		'trousers'         | 'https://www2.hm.com/pl_pl/productpage.0714032003.html' || '129,99 PLN'
		'boxers'           | 'https://www2.hm.com/pl_pl/productpage.0767577045.html' || '59,99 PLN'
	}

	def "should throw exception if URL doesn't contain price"() {
		given:
		def url = 'https://www2.hm.com/pl_pl/productpage.0123456789.html'

		when:
		sut.extract(url)

		then:
		def actual = thrown(RuntimeException)
		actual.getMessage() == "HmExtractorHandler: price not found for URL FIXME"
	}

}

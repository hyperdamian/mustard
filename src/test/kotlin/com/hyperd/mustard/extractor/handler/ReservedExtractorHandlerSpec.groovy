package com.hyperd.mustard.extractor.handler

import spock.lang.Specification
import spock.lang.Unroll

class ReservedExtractorHandlerSpec extends Specification {

	ReservedExtractorHandler sut

	def setup() {
		sut = new ReservedExtractorHandler()
	}

	@Unroll
	def 'should parse price of #product'(String product, String url, String expected) {
		when:
		def actual = sut.extract(url)

		then:
		actual == expected

		where:
		product            | url                                                             || expected
		'discounted shirt' | 'https://www.reserved.com/pl/pl/xp263-05x/men-s-shirt'          || '49,99'
		't-shirt'          | 'https://www.reserved.com/pl/pl/yu930-55m/men-s-t-shirt'        || '25,99'
		'belt'             | 'https://www.reserved.com/pl/pl/xw826-99x/bonded-leather-belt'  || '59,99'
		'shoes'            | 'https://www.reserved.com/pl/pl/ux030-99x/men-s-trekking-shoes' || '159,99'
	}

}

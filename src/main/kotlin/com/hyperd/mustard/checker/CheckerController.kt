package com.hyperd.mustard.checker

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/checker")
class CheckerController(val checkerService: CheckerService) {

	@GetMapping
	fun findAllCheckers(): Iterable<Checker> = checkerService.retrieveCheckers()

	@GetMapping("/{id}")
	fun findChecker(@PathVariable("id") id: Long): ResponseEntity<Checker> {
		val checker: Checker? = checkerService.retrieveChecker(id)
		return checker?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build<Checker>()
	}

	@PostMapping
	fun addChecker(@RequestBody checkerModel: CheckerModel) = checkerService.addChecker(checkerModel)

}

package com.hyperd.mustard.checker

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
	fun addChecker(@RequestBody checker: Checker) = checkerService.addChecker(checker.name)

}

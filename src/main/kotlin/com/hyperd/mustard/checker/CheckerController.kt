package com.hyperd.mustard.checker

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/checker")
class CheckerController(val checkerService: CheckerService) {

	@GetMapping
	fun findAllCheckers(): Iterable<Checker> = checkerService.retrieveCheckers()

	@GetMapping("/{id}")
	fun findChecker(@PathVariable("id") id: Long): Optional<Checker> =
			checkerService.retrieveChecker(id)

	@PostMapping
	fun addChecker(@RequestBody checker: Checker) = checkerService.addChecker(checker.name)

}

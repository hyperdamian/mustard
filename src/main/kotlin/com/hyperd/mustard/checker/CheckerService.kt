package com.hyperd.mustard.checker

import org.springframework.stereotype.Service
import java.util.concurrent.CopyOnWriteArrayList

@Service
class CheckerService(val checkerRepository: CheckerRepository) {

	private val checkers = CopyOnWriteArrayList<Checker>()

	fun retrieveCheckers(): Iterable<Checker> = checkerRepository.findAll()

	fun retrieveChecker(id: Long): Checker? = checkerRepository.findById(id).orElse(null)

	fun addChecker(name: String) {
		val checker = Checker(name)
		checkerRepository.save(checker)
	}

}

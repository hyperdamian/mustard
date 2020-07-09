package com.hyperd.mustard.checker

import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList

@Service
class CheckerService(val checkerRepository: CheckerRepository) {

	private val checkers = CopyOnWriteArrayList<Checker>()

	fun retrieveCheckers(): Iterable<Checker> = checkerRepository.findAll()

	fun retrieveChecker(id: Long): Optional<Checker> = checkerRepository.findById(id)

	fun addChecker(name: String) {
		val checker = Checker(name)
		checkerRepository.save(checker)
	}

}

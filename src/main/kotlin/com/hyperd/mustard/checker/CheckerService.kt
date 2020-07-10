package com.hyperd.mustard.checker

import com.hyperd.mustard.extractor.Extractor
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class CheckerService(val checkerRepository: CheckerRepository,
					 val entityManager: EntityManager) {

	fun retrieveCheckers(): Iterable<Checker> = checkerRepository.findAll()

	fun retrieveChecker(id: Long): Checker? = checkerRepository.findById(id).orElse(null)

	fun addChecker(checkerModel: CheckerModel) {
		val extractor: Extractor = entityManager.find(Extractor::class.java, checkerModel.extractorId)
		val checker = Checker(checkerModel.name, extractor)
		checkerRepository.save(checker)
	}

}

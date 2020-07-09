package com.hyperd.mustard.checker

import org.springframework.data.repository.CrudRepository

interface CheckerRepository : CrudRepository<Checker, Long> {
}

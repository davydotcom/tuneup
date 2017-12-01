package com.bertramlabs.plugins.tuneup

import grails.compiler.GrailsCompileStatic


//@GrailsCompileStatic
class SlowTransactionsController {
	static namespace = 'tuneup'

    def index() {
		return [slowTransactions: MetricManager.getSlowTransactions()]
	}

	def clear() {
		MetricManager.clearTransactions()
		redirect action: 'index', resource: 'slowTransactions', namespace: 'tuneup'
	}
}

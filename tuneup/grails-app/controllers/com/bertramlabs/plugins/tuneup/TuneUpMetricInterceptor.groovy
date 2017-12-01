package com.bertramlabs.plugins.tuneup

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class TuneUpMetricInterceptor {


	int order = HIGHEST_PRECEDENCE

	TuneUpMetricInterceptor() {
		matchAll()
	}

    boolean before() { true
		String transactionName
		if(controllerName) {
			transactionName = "[${request.method}] ${controllerNamespace ? controllerNamespace + ':': ''}${controllerName}#${actionName}"
		} else {

			transactionName = "[${request.method}] View"
		}


		TransactionData webTransaction = new TransactionData(transactionName, new Date(),'web',params)
		MetricManager.currentTransactionRecord.set(webTransaction)
		return true
	}

    boolean after() {
		TransactionData webTransaction = MetricManager.currentTransactionRecord.get()
		if(webTransaction) {
			webTransaction.completeTransaction()
		}

		return true
	}

    void afterView() {
        // no-op
		TransactionData webTransaction = MetricManager.currentTransactionRecord.get()
		if(webTransaction) {
			webTransaction.completeView()
			if(!controllerName) {
				webTransaction.name =  "[${request.method}] View - ${view}"
			}
			log.info("Request: {} completed in {}ms. View Time: {}ms - ${view}.", webTransaction.name, webTransaction.transactionTime, webTransaction.viewTime)
		}
		MetricManager.archiveCurrentTransaction()


    }
}

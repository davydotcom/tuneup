package com.bertramlabs.plugins.tuneup

import grails.util.Environment

class UrlMappings {
    static mappings = { it ->
		String baseUrl = getGrailsApplication().config.getProperty('grails.plugins.tuneup.baseUrl',String,'tuneup')
		Boolean enabled = getGrailsApplication().config.getProperty(
			'grails.plugins.tuneup.enabled',
			Boolean,
			Environment.currentEnvironment == Environment.DEVELOPMENT
		)
		if(enabled) {
			group("/${baseUrl}") {
				"/"(resources: 'slowTransactions', namespace: 'tuneup')
				"/clear"(controller: 'slowTransactions', namespace: 'tuneup', action: 'clear', method: 'POST')
			}
		}
    }
}

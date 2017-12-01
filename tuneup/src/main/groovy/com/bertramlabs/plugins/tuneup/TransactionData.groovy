package com.bertramlabs.plugins.tuneup

/**
 * A class for representing a single transaction and the various metrics gathered during that single transaction
 * @see Metric
 * @author David Estes
 */
class TransactionData {
	String name
	String id //UUID recommended here
	Long startTime
	Long endTime
	String transactionType = 'web'
	Long transactionTime = 0 //ms
	Long viewTime = 0 //ms
	Map attributes
	List<Metric> metrics

	TransactionData(String name, Date startTime, String type='web', attributes = [:]) {
		this.startTime = startTime.time
		this.name = name
		this.metrics = []
		this.attributes = attributes
		this.id = UUID.randomUUID()
	}


	public void completeTransaction() {
		this.endTime = new Date().time
		transactionTime = this.endTime - this.startTime
	}
	public void completeView() {
		viewTime = new Date().time - endTime

	}
}
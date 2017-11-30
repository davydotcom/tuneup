package com.bertramlabs.plugins.tuneup

/**
 * A class for representing a single transaction and the various metrics gathered during that single transaction
 * @see Metric
 * @author David Estes
 */
class TransactionData {
	String name
	String transactionType = 'web'
	Long transactionTime //ms
	Long viewTime //ms
	List<Metric> metrics
}
package com.bertramlabs.plugins.tuneup

import groovy.transform.CompileStatic

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 *  @author David Estes
 */
@CompileStatic
class MetricManager {

	static ThreadLocal<TransactionData> currentTransactionRecord = new ThreadLocal<>()
	static List<TransactionData> transactionRecords = [].asSynchronized();
	static private ExecutorService tuneUpExec = Executors.newFixedThreadPool(1)


	static void archiveCurrentTransaction() {
		TransactionData transaction = currentTransactionRecord.get()
		currentTransactionRecord.remove()

		Closure saveClosure = {
			transactionRecords.add(transaction)
			if(transactionRecords.size() > 500) {
				transactionRecords.remove(0)
			}
		}
		tuneUpExec.submit({ -> saveClosure()} as Callable )
	}


	static List<TransactionData> getSlowTransactions() {
		Long now = new Date().time
		Map<String,List<TransactionData>> groupedTransactions = transactionRecords.groupBy { TransactionData tmpTransaction -> tmpTransaction.name }
		List<TransactionData> slowTransactions = groupedTransactions?.collect { String key, List<TransactionData> value ->
			Long avgTime = ((value.sum{TransactionData row -> row.transactionTime + row.viewTime} as BigDecimal) / value.size()).toLong()
			value.min{ TransactionData row ->
				Math.abs((row.transactionTime + row.viewTime) - avgTime)
			}
		}?.sort{TransactionData a,TransactionData b -> -(a.transactionTime + a.viewTime) <=> -(b.transactionTime + b.viewTime)}
	}


	static void clearTransactions() {
		transactionRecords.clear()
	}

}

<html>
	<head>
		<title>Tune Up - Slow Transactions</title>
		<meta name="layout" content="tuneup"/>
	</head>
	<body>
		<g:if test="${slowTransactions}">
			<ul class="list-unstyled">
				<g:each var="transaction" in="${slowTransactions}">
					<li class="clearfix"><strong><g:link namespace="tuneup" resource="slowTransactions" action="show" id="${transaction.id}">${transaction.name}</g:link></strong>
						<span class="transaction-meta pull-right">
							<span class="transaction-time" title="${transaction.transactionTime}ms -- View: ${transaction.viewTime}ms">[${transaction.transactionTime + transaction.viewTime}ms]</span>

						</span>
					</li>
				</g:each>
			</ul>
		</g:if>
		<g:else>
			<p class="align-center">No Transactions Yet</p>
		</g:else>
	</body>

</html>
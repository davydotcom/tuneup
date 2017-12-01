<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="TuneUp"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="tuneup/application.css"/>

    <g:layoutHead/>
</head>
<body>

<div class="container">
	<div class="header clearfix">
		<nav>
			<ul class="nav nav-pills pull-right">
				<li role="presentation" class="active">
					<g:form controller="slowTransactions" namespace="tuneup" action="clear" method="POST" class="form-inline">
						<div class="input-group">
							<g:submitButton name="Clear Transactions" class="btn btn-primary btn-sm"/>
						</div>
					</g:form>
				</li>
			</ul>
		</nav>
		<h3 class="text-muted">Tune Up Metrics</h3>
	</div>



	<div class="row marketing">
		<div class="col-xs-12">
			<g:layoutBody/>
		</div>
	</div>



</div> <!-- /container -->

    <asset:javascript src="tuneup/application.js"/>

</body>
</html>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'puzzle.label', default: 'Puzzle')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-puzzle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav">
                <div class="col-md-1">
                    <a class="btn btn-success" href="${createLink(uri: '/')}">Home</a>
                </div>
                <div class="col-md-2">
                    <g:link class="btn btn-success" action="listPuzzles">Puzzle List</g:link>
                </div>
		</div>
		<div id="create-puzzle" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${puzzleInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${puzzleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:puzzleInstance, action:'save', method:'post']" >
                <div class="row">
                <g:render template="form"/>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-2">
                        <g:render template="sudokuGrid"/>
                    </div>
                </div>
                <h3 id="error"></h3>
                <br/>
                <div class="row">
                    <div class="col-md-1"></div>
                    <g:submitButton id="create" name="create" class="col-md-1 col-md-offset-1 btn btn-success" value="Create"/>
                </div>
                <g:hiddenField id="givenValues" name="givenValues"></g:hiddenField>
			</g:form>
		</div>
    <g:javascript>
        $('#create').click(function(event){
            var tableData = "";
            var givenCount =0;
            $('#puzzleGrid').find("td").each(function(){
                var cell = $(this).find("input").val();
                if(cell != 0) {
                    tableData += $(this).find("input").attr("id") + ':' + cell + ',';
                    givenCount++;
                }
            });
            if(givenCount<17){
                event.preventDefault(); // cancel default behavior
                $('#error').attr('style', 'color:red');
                $('#error').html('There should be a minimum of 17 given values for any Sudoku puzzle');
            }
            else {
                $('#givenValues').val(tableData);
            }
        });
    </g:javascript>
	</body>
</html>

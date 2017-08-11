
<%@ page import="com.sudoku.Puzzle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'puzzle.label', default: 'Puzzle')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-puzzle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav">
            <div class="col-md-1">
                <a class="btn btn-success" href="${createLink(uri: '/')}">Home</a>
            </div>
            <div class="col-md-2">
                <g:link class="btn btn-success" action="listPuzzles">Puzzle List</g:link>
            </div>
        </div>
		<div id="show-puzzle" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list puzzle">
			
				<g:if test="${puzzleInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="puzzle.title.label" default="Title" /></span>
					
						<span id="title" class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${puzzleInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${puzzleInstance?.author}">
				<li class="fieldcontain">
					<span id="author-label" class="property-label"><g:message code="puzzle.author.label" default="Author" /></span>
					
						<span id="author" class="property-value" aria-labelledby="author-label"><g:fieldValue bean="${puzzleInstance}" field="author"/></span>
					
				</li>
				</g:if>

				<g:if test="${puzzleInstance?.difficulty}">
				<li class="fieldcontain">
					<span id="difficulty-label" class="property-label"><g:message code="puzzle.difficulty.label" default="Difficulty" /></span>
					
						<span id="difficulty" class="property-value" aria-labelledby="difficulty-label"><g:fieldValue bean="${puzzleInstance}" field="difficulty"/></span>

				</g:if>

                <g:if test="${puzzleInstance?.givenValues}">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-2">
                            <g:render template="sudokuGrid"/>
                        </div>
                    </div>

                    <g:hiddenField id="givenValues" name="givenValues" value="${puzzleInstance.givenValues}"></g:hiddenField>
                    <span id="scoreLabel">Timer: </span><h3 name="visibleScore" id="visibleScore">0:00</h3>
                </g:if>
                <h2 id="invalidSolution" style="color: red" value=""/>
			</ol>
            <g:form url="[resource:puzzleInstance]">
                <g:hiddenField name="score" id="score" value="0:00"></g:hiddenField>
				<fieldset>
                    <g:actionSubmit id="submit" action="submitSolution" class="btn btn-success" name="submit" value="Submit"/>
                </fieldset>
			</g:form>
		</div>
    <g:javascript>
        window.onload = function() {
            var stringValues = $('#givenValues').val();
            var givenArr = stringValues.split(",");
            var givenValues = {};
            givenArr.forEach(function(it) {
                it = it.split(':');
                givenValues[it[0]] = it[1]
            });
            Object.keys(givenValues).forEach(function (key) {
                $('#'+key).val(givenValues[key]);
                $('#'+key).prop('disabled', true);
            });

        };
        var seconds = 0;
        var minutes = 0;
        setInterval(function(){
            seconds ++;
            if(seconds == 60){
                seconds = 0;
                minutes ++;
            }
            var timer = (seconds < 10)? minutes+':0'+seconds : minutes+':'+seconds
            $("#score").val(timer);$("#visibleScore").html(timer);
        }, 1000);
        $("#submit").click(function(event)
        {
            if(validateSolution() == false){
                event.preventDefault(); // cancel default behavior
                $('#invalidSolution').html('Not quite, try again!');
            }
        });

    </g:javascript>
	</body>
</html>

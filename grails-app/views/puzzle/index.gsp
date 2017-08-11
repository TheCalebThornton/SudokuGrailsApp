
<%@ page import="com.sudoku.Puzzle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'puzzle.label', default: 'Puzzle')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-puzzle" class="content scaffold-list" role="main">
            <div class="nav">
                <div class="col-md-1">
                    <a class="btn btn-success" href="${createLink(uri: '/')}">Home</a>
                </div>
            </div>
			<h1 class="pull-left">Puzzle List by Difficulty</h1>
            <g:form class="pull-right" action="listPuzzles">
                <label class="text-muted" for="difficulty">Select Difficulty:</label><g:select name="difficulty"
                                                                                     from="${['Easy', 'Medium', 'Hard', 'Extreme']}"
                                                                                     value="${difficulty}" onchange="submit()"/>
            </g:form>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table name="puzzleList" id="puzzleList">
			<thead>
					<tr>

                        <g:sortableColumn property="title" title="${message(code: 'puzzle.title.label', default: 'Title')}" />

						<g:sortableColumn property="author" title="${message(code: 'puzzle.author.label', default: 'Author')}" />

						<g:sortableColumn property="difficulty" title="${message(code: 'puzzle.difficulty.label', default: 'Difficulty')}" />

                        <g:sortableColumn property="highScore" title="${message(code: 'puzzle.highScore.label', default: 'HighScore (in Minutes)')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${puzzleList}" status="i" var="puzzleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'} ">
					
						<td><g:link action="show" id="${puzzleInstance.id}">${fieldValue(bean: puzzleInstance, field: "title")}</g:link></td>
					
						<td>${fieldValue(bean: puzzleInstance, field: "author")}</td>
					
						<td>${fieldValue(bean: puzzleInstance, field: "difficulty")}</td>

                        <td class="highScore"><g:formatNumber number="${fieldValue(bean: puzzleInstance, field: "highScore")}" type="number" groupingUsed="false" minFractionDigits="2"/></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${puzzleInstanceCount ?: 0}" />
			</div>
            <br/>
            <div class="col-md-2 pull-left">
                <g:link class="btn btn-success" action="create">Create New Puzzle</g:link>
            </div>
            <br/>
		</div>
    <g:javascript>
        $( document ).ready(
        function formatHighScore(){
            $('.highScore').each(function(){
                var score = $(this).html();
                $(this).html(score.replace('.', ':'));
            });

        });
    </g:javascript>
	</body>
</html>

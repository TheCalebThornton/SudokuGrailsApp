
<%@ page import="com.sudoku.Puzzle" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'puzzle.label', default: 'Puzzle')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-puzzle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
        <div class="col-md-1">
            <a class="btn btn-success" href="${createLink(uri: '/')}">Home</a>
        </div>
</div>
<div id="list-puzzle" class="content scaffold-list" role="main">
    <h1 id="grats">Congratulations! You completed ${author}'s ${difficulty} Sudoku puzzle</h1><br/>
    <h1 id="scoreLabel">Your score was: </h1><h1 id="score" class="highScore">${score}</h1>

    <br/>
    <g:link class="btn btn-success" action="index" id="play">Solve More Puzzles</g:link>
    <g:link class="btn btn-success" action="create" id="create">Create a Puzzle</g:link>
    <g:link class="btn btn-success" action="" id="solver">Use the Puzzle Solver</g:link>

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
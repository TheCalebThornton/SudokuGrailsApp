
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Mr. Sudoku Bot</title>
</head>
<body>
    <div class="nav">
        <div class="col-md-1">
            <a class="btn btn-success" href="${createLink(uri: '/')}">Home</a>
        </div>
    </div>
<div id="show-puzzle" class="content scaffold-show" role="main">
    <h1>Enter your unfinished puzzle and I will solve it for you!</h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div class="row">
        <div class="col-md-6 col-md-offset-2">
            <g:render template="../puzzle/sudokuGrid"/>
        </div>
        <br/><br/>
        <h2 class="col-md-4" id="solveMessage"></h2>
    </div>
    <div class="row">
        <div class="col-md-2"></div>
        <button id="solve" name="solve" class="col-md-1 btn btn-success" onClick="postSolutionInTable()">Solve It!</button>
    </div>

</div>
<g:javascript>
    function postSolutionInTable(){
        var puzzle = pullPuzzleFromTable();
        var solution = solver(puzzle);
        $('#puzzleGrid').find("td").each(function(){
            var cell = $(this).find("input");
            //use id from view to determine the appropriate location in the array
            cell.val(solution[parseInt(cell.attr("id").charCodeAt(0)-65)][parseInt(cell.attr("id").charAt(1)-1)])
        });
        $('#solveMessage').html("TADA! That was too easy, you really couldn't do that?");
    }
</g:javascript>
</body>
</html>

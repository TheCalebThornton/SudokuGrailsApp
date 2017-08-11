<%@ page import="com.sudoku.Puzzle" %>
<div class="fieldcontain ${hasErrors(bean: puzzleInstance, field: 'title', 'error')} ">
    <label for="title">
        <g:message code="puzzle.title.label" default="Title" />

    </label>
    <g:textField name="title" value="${puzzleInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: puzzleInstance, field: 'author', 'error')} ">
	<label for="author">
		<g:message code="puzzle.author.label" default="Author" />
		
	</label>
	<g:textField name="author" value="${puzzleInstance?.author}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: puzzleInstance, field: 'givenValues', 'error')} required">
    <label for="puzzleGrid">
        <g:message code="puzzle.puzzleGrid.label" default="Sudoku Puzzle" />
    </label>
<!-- Sudoku table -->
<div class="row">
    <div class="col-md-3">
    <table id="puzzleGrid" class="sudokuTable">
        <tbody>
        <tr>
            <td class="bdr00"><input id="A1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="A2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="A3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr00"><input id="A4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="A5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="A6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr00"><input id="A7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="A8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="A9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>
        <tr>
            <td class="bdr01"><input id="B1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="B2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="B3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr01"><input id="B4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="B5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="B6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr01"><input id="B7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="B8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="B9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>
        <tr class="thirdRow">
            <td class="bdr02"><input id="C1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="C2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="C3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr02"><input id="C4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="C5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="C6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr02"><input id="C7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="C8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="C9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>

        <!--Second Row of Boxes-->
        <tr>
            <td class="bdr00"><input id="D1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="D2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="D3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr00"><input id="D4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="D5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="D6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr00"><input id="D7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="D8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="D9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>
        <tr>
            <td class="bdr01"><input id="E1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="E2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="E3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr01"><input id="E4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="E5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="E6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr01"><input id="E7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="E8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="E9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>
        <tr class="thirdRow">
            <td class="bdr02"><input id="F1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="F2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="F3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr02"><input id="F4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="F5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="F6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr02"><input id="F7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="F8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="F9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>
        <!--Third Row of boxes-->
        <tr>
            <td class="bdr00"><input id="G1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="G2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="G3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr00"><input id="G4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="G5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="G6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr00"><input id="G7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr10"><input id="G8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr20"><input id="G9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>
        <tr>
            <td class="bdr01"><input id="H1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="H2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="H3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr01"><input id="H4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="H5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="H6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr01"><input id="H7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr11"><input id="H8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr21"><input id="H9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>
        <tr class="thirdRow">
            <td class="bdr02"><input id="I1" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="I2" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="I3" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr02"><input id="I4" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="I5" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="I6" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr02"><input id="I7" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr12"><input id="I8" value="0" type="tel" size="1" maxlength="1" /></td>
            <td class="bdr22"><input id="I9" value="0" type="tel" size="1" maxlength="1" /></td>
        </tr>
        </tbody>
    </table>
    </div>
    <div class="col-md-6"></div>
</div>
</div>
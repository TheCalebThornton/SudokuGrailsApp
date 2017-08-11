function validateSolution(){
    var tableData = [[]];
    var valueArr = [];
    var index=0;
    $('#puzzleGrid').find("td").each(function(){
        var cell = $(this).find("input").val();
        if(cell != 0) {
            valueArr[index] = cell;
            index++;
        }
    });
    index =0;
    //If the array is not 81 it is invalid. stop validation and return 0
    if(valueArr.length != 81){return false}
    for(var row=0; row<9; row++){
        for(var col=0; col<9; col++){
            tableData[row][col] = valueArr[index];
            index++;
        }
    }
    return  checkSolutionValues(tableData)
}

function checkSetValues(numberSet){
    if(numberSet.size != 9){return false}//check duplicates
    for(var i=1; i<=9;i++){
        if(!numberSet.has(i)){return false}//check that set contains all values
    }

    return true;
}

function checkSolutionValues(solution){
    var set = new Set();
    //check rows
    for(var row=0;row<9;row++){
      set.clear();
      for(var col=0;col<9;col++){
          set.add(solution[row][col]);//assign each row value to set
      }
      if(!checkSetValues(set)){return false}
    }
    //check columns
    for(var col=0;col<9;col++){
        for(var row=0;row<9;row++){
            set.add(solution[row][col]);//assign each column value to the set
        }
        if(!checkSetValues(set)){return false}
        set.clear();
    }
    //check boxes
    for(var offset=0; offset<9;offset += 3){
        for(var row=offset;row<(3+offset);row++){
            for(var col=offset;col<(3+offset);col++){
                set.add(solution[row][col]);
            }
        }
        if(!checkSetValues(set)){return false}
        set.clear();
    }
    return true;
}

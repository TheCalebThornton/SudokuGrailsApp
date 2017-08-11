function pullPuzzleFromTable(){
		var tableData = [[],[],[],[],[],[],[],[],[]];
		$('#puzzleGrid').find("td").each(function(){
				var cell = $(this).find("input");
				//use id text to translate array position
				tableData[parseInt(cell.attr("id").charCodeAt(0)-65)][parseInt(cell.attr("id").charAt(1)-1)] =
										(cell.val()!= ""&&cell.val()!=null)? parseInt(cell.val()) : 0; //account for empty cells
		});
		return tableData
}

function solver(puzzle) {
		sudokuSolver(puzzle, 0,0);
		return puzzle;

		function sudokuSolver(puzzle, row, column) {
				//base case
				if (9 == row) {
						return true;
				}

				//check if current sector is already assigned
				if (puzzle[row][column] != 0) {
						if (column == 8) {
								if (sudokuSolver(puzzle, row+1, 0)) return true;
						} else {
								if (sudokuSolver(puzzle, row, column+1)) return true;
						}
						return false;
				}
				//Adjust algorithm
				//pruning proccess

				//iterate through possible numbers (1-9) for empty sector
				for (var i=1; i<10; i++) {
						//check if the number follows sudoku rules
						if(isValid(i, puzzle, row, column)) {
								puzzle[row][column] = i;
								if (column == 8) {
										if (sudokuSolver(puzzle, row+1, 0)) return true;
								} else {
										if (sudokuSolver(puzzle, row, column+1)) return true;
								}
								//failed to find a valid value for the sector
								puzzle[row][column] = 0;
						}
				}
		}

		function isValid(number, puzzle, row, column) {
				var row1 = 0;
				var row2 = 0;
				var col1 = 0;
				var col2 = 0;

				//Check for the value in the given row and column
				for (var i=0; i<9; i++) {
						if (puzzle[i][column] == number) return false;
						if (puzzle[row][i] == number) return false;
				}
				//Checking 3x3
				//Check which sectors are left to be evaluated based on the position in the 3x3 box
				if((row+1)%3 == 1){
						row1 = row+1;
						row2 = row+2;
				}
				else if((row+1)%3 == 2){
						row1 = row-1;
						row2 = row+1;
				}
				else if((row+1)%3 == 0){
						row1 = row-1;
						row2 = row-2;
				}
				if((column+1)%3 == 1){
						col1 = column+1;
						col2 = column+2;
				}
				else if((column+1)%3 == 2){
						col1 = column-1;
						col2 = column+1;
				}
				else if((column+1)%3 == 0){
						col1 = column-1;
						col2 = column-2;
				}
				//Check for the number in the reaming four sectors of the 3x3
				if(puzzle[row1][col1] == number) return false;
				if(puzzle[row2][col1] == number) return false;
				if(puzzle[row1][col2] == number) return false;
				if(puzzle[row2][col2] == number) return false;
				return true;
		}
}

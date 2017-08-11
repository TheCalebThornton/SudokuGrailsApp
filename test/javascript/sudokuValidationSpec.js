describe("sudokuValidation", function(){
	describe("checkSetValues", function(){
		it("returns true when a set contians values 1-9", function(){
			var validSet = new Set()
			validSet.add(1)
			validSet.add(2)
			validSet.add(3)
			validSet.add(4)
			validSet.add(5)
			validSet.add(6)
			validSet.add(7)
			validSet.add(8)
			validSet.add(9)
			expect(checkSetValues(validSet)).toBe(true);
		});

		it("returns false when a set less than 9 items large", function(){
			var smallSet = new Set();
			smallSet.add(1)
			smallSet.add(2)
			smallSet.add(3)
			smallSet.add(4)
			smallSet.add(5)
			smallSet.add(6)
			smallSet.add(7)
			smallSet.add(8)
			expect(checkSetValues(smallSet)).toBe(false);
		});

		it("returns false when a set larger than 9 items", function(){
			var largeSet = new Set()
			largeSet.add(1)
			largeSet.add(2)
			largeSet.add(3)
			largeSet.add(4)
			largeSet.add(5)
			largeSet.add(6)
			largeSet.add(7)
			largeSet.add(8)
			largeSet.add(9)
			largeSet.add(10)
			expect(checkSetValues(largeSet)).toBe(false)
		});

		it("returns false when a set does not contain values 1-9", function(){
			var invalidSet = new Set()
			invalidSet.add(0)
			invalidSet.add(2)
			invalidSet.add(3)
			invalidSet.add(4)
			invalidSet.add(5)
			invalidSet.add(6)
			invalidSet.add(7)
			invalidSet.add(8)
			invalidSet.add(9)
			expect(checkSetValues(invalidSet)).toBe(false)
		});
		it("returns false when a set contains 9 values but two are the same value", function(){
			var invalidSet = new Set()
			invalidSet.add(1)
			invalidSet.add(1)
			invalidSet.add(3)
			invalidSet.add(4)
			invalidSet.add(5)
			invalidSet.add(6)
			invalidSet.add(7)
			invalidSet.add(8)
			invalidSet.add(9)
			expect(checkSetValues(invalidSet)).toBe(false)
		});
	});


	describe("checkSolutionValues", function(){
		it("returns true when the solution is valid", function(){
			var validSolution = [
								[8,2,6,1,9,3,7,4,5],
                [1,9,5,4,7,8,3,2,6],
                [3,4,7,5,2,6,1,8,9],
                [4,8,2,9,1,7,5,6,3],
                [6,3,9,8,5,2,4,1,7],
                [5,7,1,6,3,4,2,9,8],
                [2,6,8,3,4,5,9,7,1],
                [9,5,4,7,6,1,8,3,2],
                [7,1,3,2,8,9,6,5,4]]
			expect(checkSolutionValues(validSolution)).toBe(true)
		});

		it("returns false when the solution violates the row rules of sudoku", function(){
			var invalidSolution = [
								[1,2,3,1,2,3,1,2,3],
                [4,5,6,4,5,6,4,5,6],
                [7,8,9,7,8,9,7,8,9],
                [2,3,1,2,3,1,2,3,1],
                [3,1,2,3,1,2,3,1,2],
                [5,6,4,5,6,4,5,6,4],
                [6,4,5,6,4,5,6,4,5],
                [8,9,7,8,9,7,8,9,7],
                [9,7,8,9,7,8,9,7,8]]
			expect(checkSolutionValues(invalidSolution)).toBe(false)
		});
		it("returns false when the solution violates the column rules of sudoku", function(){
			var invalidSolution = [
								[1,2,3,4,5,6,7,8,9],
								[7,8,9,1,2,3,4,5,6],
								[4,5,6,7,8,9,1,2,3],
								[1,2,3,4,5,6,7,8,9],
								[7,8,9,1,2,3,4,5,6],
								[4,5,6,7,8,9,1,2,3],
								[1,2,3,4,5,6,7,8,9],
								[7,8,9,1,2,3,4,5,6],
								[4,5,6,7,8,9,1,2,3]]
			expect(checkSolutionValues(invalidSolution)).toBe(false)
		});

		it("returns false when the solution violates the box rules of sudoku", function(){
			var invalidSolution = [
								[1,2,3,4,5,6,7,8,9],
                [2,3,4,5,6,7,8,9,1],
                [3,4,5,6,7,8,9,1,2],
                [4,5,6,7,8,9,1,2,3],
                [5,6,7,8,9,1,2,3,4],
                [6,7,8,9,1,2,3,4,5],
                [7,8,9,1,2,3,4,5,6],
                [8,9,1,2,3,4,5,6,7],
                [9,1,2,3,4,5,6,7,8]]
			expect(checkSolutionValues(invalidSolution)).toBe(false)
		});
	});
});

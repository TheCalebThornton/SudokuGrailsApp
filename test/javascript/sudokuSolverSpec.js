describe("sudokuSolver", function(){
    it("returns a valid solution when an unsolved puzzle is given", function(){
      var puzzle = [
        [5,3,0,0,7,0,0,0,0],
        [6,0,0,1,9,5,0,0,0],
        [0,9,8,0,0,0,0,6,0],
        [8,0,0,0,6,0,0,0,3],
        [4,0,0,8,0,3,0,0,1],
        [7,0,0,0,2,0,0,0,6],
        [0,6,0,0,0,0,2,8,0],
        [0,0,0,4,1,9,0,0,5],
        [0,0,0,0,8,0,0,7,9]];

      var solution = [
        [5,3,4,6,7,8,9,1,2],
        [6,7,2,1,9,5,3,4,8],
        [1,9,8,3,4,2,5,6,7],
        [8,5,9,7,6,1,4,2,3],
        [4,2,6,8,5,3,7,9,1],
        [7,1,3,9,2,4,8,5,6],
        [9,6,1,5,3,7,2,8,4],
        [2,8,7,4,1,9,6,3,5],
        [3,4,5,2,8,6,1,7,9]];
        expect(solver(puzzle)).toEqual(solution);
    });

    it("returns a valid solution when an unsolved easy puzzle is given", function(){
      var puzzle = [
          [0,0,0,1,0,0,0,4,0],
          [1,9,5,0,0,8,0,0,0],
          [3,4,0,0,2,0,1,0,9],
          [0,0,0,9,1,0,5,0,0],
          [6,0,9,8,0,2,4,0,7],
          [0,0,1,0,3,4,0,0,0],
          [2,0,8,0,4,0,0,7,1],
          [0,0,0,7,0,0,8,3,2],
          [0,1,0,0,0,9,0,0,0]
      ];
      var solution = [
          [8,2,6,1,9,3,7,4,5],
          [1,9,5,4,7,8,3,2,6],
          [3,4,7,5,2,6,1,8,9],
          [4,8,2,9,1,7,5,6,3],
          [6,3,9,8,5,2,4,1,7],
          [5,7,1,6,3,4,2,9,8],
          [2,6,8,3,4,5,9,7,1],
          [9,5,4,7,6,1,8,3,2],
          [7,1,3,2,8,9,6,5,4]
      ];

        expect(solver(puzzle)).toEqual(solution);
    });

    it("returns a valid solution when an unsolved medium puzzle is given", function(){
      var puzzle = [[3,0,0,0,0,0,0,7,8],
                 [0,0,0,0,0,8,3,4,0],
                 [8,0,0,2,0,4,5,0,0],
                 [0,3,0,0,8,0,4,2,0],
                 [2,0,0,0,6,0,0,0,1],
                 [0,4,8,0,1,0,0,3,0],
                 [0,0,3,8,0,5,0,0,2],
                 [0,5,9,7,0,0,0,0,0],
                 [1,8,0,0,0,0,0,0,4]]

      var solution = [[3,1,4,6,5,9,2,7,8],
                   [5,2,6,1,7,8,3,4,9],
                   [8,9,7,2,3,4,5,1,6],
                   [6,3,1,9,8,7,4,2,5],
                   [2,7,5,4,6,3,9,8,1],
                   [9,4,8,5,1,2,6,3,7],
                   [7,6,3,8,4,5,1,9,2],
                   [4,5,9,7,2,1,8,6,3],
                   [1,8,2,3,9,6,7,5,4]]

        expect(solver(puzzle)).toEqual(solution);
    });

    it("returns a valid solution when an unsolved hard puzzle is given", function(){
      var puzzle = [[0,0,9,0,0,0,7,3,1],
                 [0,3,0,0,0,7,0,0,0],
                 [0,0,0,3,4,0,8,0,0],
                 [7,0,0,0,0,0,0,5,0],
                 [8,9,0,5,0,6,0,4,7],
                 [0,5,0,0,0,0,0,0,6],
                 [0,0,6,0,5,9,0,0,0],
                 [0,0,0,2,0,0,0,1,0],
                 [5,8,2,0,0,0,3,0,0]]
      var solution = [[4,2,9,6,8,5,7,3,1],
                   [1,3,8,9,2,7,5,6,4],
                   [6,7,5,3,4,1,8,9,2],
                   [7,6,4,8,9,2,1,5,3],
                   [8,9,3,5,1,6,2,4,7],
                   [2,5,1,4,7,3,9,8,6],
                   [3,1,6,7,5,9,4,2,8],
                   [9,4,7,2,3,8,6,1,5],
                   [5,8,2,1,6,4,3,7,9]]

        expect(solver(puzzle)).toEqual(solution);
    });

    it("returns a valid solution when an unsolved extreme puzzle is given", function(){
      var puzzle = [[8,0,5,0,0,0,0,3,0],
                 [0,3,0,9,0,0,0,0,0],
                 [4,0,6,0,3,0,0,0,0],
                 [6,0,0,0,1,0,9,0,0],
                 [0,5,0,3,0,8,0,7,0],
                 [0,0,9,0,4,0,0,0,1],
                 [0,0,0,0,2,0,3,0,8],
                 [0,0,0,0,0,9,0,2,0],
                 [0,7,0,0,0,0,5,0,4]]
      var solution = [[8,1,5,6,7,4,2,3,9],
                   [7,3,2,9,5,1,4,8,6],
                   [4,9,6,8,3,2,7,1,5],
                   [6,8,7,2,1,5,9,4,3],
                   [1,5,4,3,9,8,6,7,2],
                   [3,2,9,7,4,6,8,5,1],
                   [9,4,1,5,2,7,3,6,8],
                   [5,6,3,4,8,9,1,2,7],
                   [2,7,8,1,6,3,5,9,4]]

        expect(solver(puzzle)).toEqual(solution);
    });
});

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> finalresult = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                board[i][j] = '.';
            }
        }
        addingqueens(0,board,finalresult);
        return finalresult;
    }
    public void addingqueens(int column, char board[][], List<List<String>> finalresult)
    {
        if(column == board.length)
        {
            finalresult.add(convert(board));
            return;
        }
        for(int row = 0; row < board.length; row++)
        {
            if(checkingqueens(row,column,board) == true)
            {
                board[row][column] = 'Q';
                addingqueens(column+1, board, finalresult);
                board[row][column] = '.';
            }
        }
    }
    public boolean checkingqueens(int row, int column, char board[][])
    {
        int i = row;
        int j = column;
        while(j >= 0)
        {
            if(board[i][j] == 'Q') return false;
            j--;
        }
        i = row;
        j = column;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = row;
        j = column;
        while(i < board.length && j >= 0)
        {
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }
        return true;
    }
    public List<String> convert(char board[][])
    {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++)
        {
            String str = new String(board[i]);
            ans.add(str);
        }
        return ans;
    }
}
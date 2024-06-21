package bitcamp.myapp.command;

import bitcamp.myapp.vo.Board;

public class BoardList {

    private static final int MAX_SIZE = 100; // 변하지 않기 때문에 static 유지

    private Board[] boards = new Board[MAX_SIZE];
    private int boardLength = 0;

    /*public static void add(BoardList that, Board board) {
        that.boards[that.boardLength++] = board;
    }*/
    public void add(Board board) {
        this.boards[this.boardLength++] = board;
    }

    public Board delete(int userNo) {
        Board deletedBoard = findByNo(userNo);
        if (deletedBoard == null) {
            return null;
        }
        int index = indexOf(deletedBoard);
        for (int i = index + 1; i < this.boardLength; i++) {
            this.boards[i - 1] = this.boards[i];
        }
        this.boards[--this.boardLength] = null;
        return deletedBoard;
    }

    public Board[] toArray() {
        Board[] arr = new Board[this.boardLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.boards[i];
        }
        return arr;
    }

    public Board findByNo(int userNo) {
        for (int i = 0; i < this.boardLength; i++) {
            Board board = this.boards[i];
            if (board.getNo() == userNo) {
                return board;
            }
        }
        return null;
    }

    public int indexOf(Board board) {
        for (int i = 0; i < this.boardLength; i++) {
            if (this.boards[i] == board) {
                return i;
            }
        }
        return -1;
    }
}

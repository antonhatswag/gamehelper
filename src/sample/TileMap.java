package sample;

public class TileMap {


    int width;
    int height;
    int[][] board;

    public TileMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }
}

/*
8 На клетчатом листе бумаги закрашена часть клеток. Выделить все различные фигуры,
которые образовались при этом. Фигурой считается набор закрашенных клеток, достижимых друг
из друга при движении в четырёх направлениях. Две фигуры являются различными, если их нельзя
 совместить поворотом на угол, кратный 90 градусам, и параллельным переносом. Используйте класс HashSet.
 */
import java.util.*;

class FiguresOnGrid {

    public static void main(String[] args) {
        boolean[][] grid = {
                {true, true, false, false},
                {true, false, true, false},
                {false, true, false, false},
                {false, false, false, true}
        };
        Set<Set<String>> figures = findFigures(grid);
        System.out.println(figures);
    }

    public static Set<Set<String>> findFigures(boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<Set<String>> figures = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    Set<String> figure = new HashSet<>();
                    dfs(grid, visited, figure, i, j,i,j);
                    figures.add(figure);
                }
            }
        }
        return figures;
    }

    public static void dfs(boolean[][] grid, boolean[][] visited, Set<String> figure, int i, int j, int i_min, int j_min) {
        int n = grid.length;
        int m = grid[0].length;
        visited[i][j] = true;
        figure.add("{"+(i-i_min) +", "+ (j-j_min)+"}");
        if (i > 0 && grid[i - 1][j] && !visited[i - 1][j]) {
            dfs(grid, visited, figure, i - 1, j,i_min,j_min);
        }
        if (i < n - 1 && grid[i + 1][j] && !visited[i + 1][j]) {
            dfs(grid, visited, figure, i + 1, j,i_min,j_min);
        }
        if (j > 0 && grid[i][j - 1] && !visited[i][j - 1]) {
            dfs(grid, visited, figure, i, j - 1,i_min,j_min);
        }
        if (j < m - 1 && grid[i][j + 1] && !visited[i][j + 1]) {
            dfs(grid, visited, figure, i, j + 1,i_min,j_min);
        }
    }
}
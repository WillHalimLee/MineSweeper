/*
 * TCSS 360 - Assignment One.
 * Halim Lee
 * Marrok Young
 * Andrew Chon
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit testing for the MineSweeper Application.
 *
 * @author Halim Lee, Marrok Young, Andrew Chon.
 * @version June 2023.
 */
public class MineSweeperTest {

    /** A MineSweeper Object to use for testing.*/
    private MineSweeper minesweeper;

    /** Initializing our Minesweeper Object before each test.*/
    @BeforeEach
    public final void setup() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/team_minesweeper_input.txt"));
        minesweeper = new MineSweeper(input);
    }

    /** Tests the createField method with a 1x1 field that should have no mines. */
    @Test
    public final void testCreateField_OneDot() {
        String input = "1 1\n" +
                ".";
        Scanner scanner = new Scanner(input);
        minesweeper.createField(scanner);

        char[][] expectedField = {{'.'}};
        Assertions.assertArrayEquals(expectedField, minesweeper.myField);
    }

    /** Tests the createField method with a 1x1 field that should have only mines. */
    @Test
    public final void testCreateField_OneMine() {
        String input = "1 1\n" +
                "*";
        Scanner scanner = new Scanner(input);
        minesweeper.createField(scanner);

        char[][] expectedField = {{'*'}};
        Assertions.assertArrayEquals(expectedField, minesweeper.myField);
    }
    /** Test for our createField Method.*/
    @Test
    public void testCreateField() {
        String input = "4 4\n" +
                ".**.\n" +
                "*..*\n" +
                ".**.\n" +
                "*..*";

        Scanner scanner = new Scanner(input);
        minesweeper.createField(scanner);

        char[][] expectedField = {
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'},
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'}
        };

        Assertions.assertArrayEquals(expectedField, minesweeper.myField);
    }

    /** Test for our decodeField Method when the input is 1x1 with no mines.*/
    @Test
    public void testDecodeField_OneByOne_NoMines(){
       final char[][] oneByOne = {{'.'}};
            minesweeper.decodeField(oneByOne, minesweeper.myFieldNumber);

       final char[][] expectedField = {{'0'}};

        Assertions.assertArrayEquals(expectedField, oneByOne);

    }

    /** Test for our decodeField Method when the input is 1x1 with all mines.*/
    @Test
    public void testDecodeField_OneByOne_AllMines() {
        char[][] oneByOne = {
                {'*'}
        };
        minesweeper.decodeField(oneByOne, minesweeper.myFieldNumber);
        char[][] expectedField = {{'*'}};
        Assertions.assertArrayEquals(expectedField, oneByOne);
    }

    /** Test for our decodeField Method when the input is 1x10 with no mines.*/
    @Test
    public void testDecodeField_OneByTen_NoMines() {
        char[][] tenByTen = new char[1][10];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                tenByTen[i][j] = '.';
            }
        }
        minesweeper.decodeField(tenByTen, minesweeper.myFieldNumber);
        char[][] expectedField = {
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},

        };
        Assertions.assertArrayEquals(expectedField, tenByTen);
    }

    /** Test for our decodeField Method when the input is 1x10 with all mines.*/
    @Test
    public void testDecodeField_OneByTen_AllMines() {
        char[][] tenByTen = new char[1][10];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                tenByTen[i][j] = '*';
            }
        }
        minesweeper.decodeField(tenByTen, minesweeper.myFieldNumber);
        char[][] expectedField = {
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}

        };
        Assertions.assertArrayEquals(expectedField, tenByTen);
    }

    /** Test for our decodeField Method when the input is 10x1 with no mines.*/
    @Test
    public void testDecodeField_TenByOne_NoMines() {
        char[][] tenByTen = new char[10][1];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1; j++) {
                tenByTen[i][j] = '.';
            }
        }
        minesweeper.decodeField(tenByTen, minesweeper.myFieldNumber);
        char[][] expectedField = {
                {'0'},
                {'0'},
                {'0'},
                {'0'},
                {'0'},
                {'0'},
                {'0'},
                {'0'},
                {'0'},
                {'0'}
        };
        Assertions.assertArrayEquals(expectedField, tenByTen);
    }

    /** Test for our decodeField Method when the input is 10x1 with all mines.*/
    @Test
    public void testDecodeField_TenByOne_AllMines() {
        char[][] tenByOne = new char[10][1];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1; j++) {
                tenByOne[i][j] = '*';
            }
        }
        minesweeper.decodeField(tenByOne, minesweeper.myFieldNumber);
        char[][] expectedField = {
                {'*'},
                {'*'},
                {'*'},
                {'*'},
                {'*'},
                {'*'},
                {'*'},
                {'*'},
                {'*'},
                {'*'}
        };
        Assertions.assertArrayEquals(expectedField, tenByOne);
    }

    /** Test for our decodeField Method when the input is 10x10 with all mines.*/
    @Test
    public void testDecodeField_TenByTen_AllMines() {
        char[][] tenByTen = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tenByTen[i][j] = '*';
            }
        }
        minesweeper.decodeField(tenByTen, minesweeper.myFieldNumber);
        char[][] expectedField = {
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
        };
        Assertions.assertArrayEquals(expectedField, tenByTen);
    }

    /** Test for our decodeField Method when the input is 10x10 with no mines.*/
    @Test
    public void testDecodeField_TenByTen_NoMines() {
        char[][] tenByTen = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tenByTen[i][j] = '.';
            }
        }
        minesweeper.decodeField(tenByTen, minesweeper.myFieldNumber);
        char[][] expectedField = {
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0'}
        };
        Assertions.assertArrayEquals(expectedField, tenByTen);
    }

    /** Test for our decodeField Method when the input is 100x100 with all mines.*/
    @Test
    public final void testDecodeField_HundredByHundred_AllMines() {
        char[][] hundredByHundred = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                hundredByHundred[i][j] = '*';
            }
        }
        minesweeper.decodeField(hundredByHundred, minesweeper.myFieldNumber);

        char[][] expectedField = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                expectedField[i][j] = '*';
            }
        }

        Assertions.assertArrayEquals(expectedField, hundredByHundred);
    }
    /** Test for our decodeField Method when the input is 100x100 with no mines.*/
    @Test
    public final void testDecodeField_HundredByHundred_AllDots() {
        char[][] hundredByHundred = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                hundredByHundred[i][j] = '.';
            }
        }
        minesweeper.decodeField(hundredByHundred, minesweeper.myFieldNumber);

        char[][] expectedField = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                expectedField[i][j] = '0';
            }
        }

        Assertions.assertArrayEquals(expectedField, hundredByHundred);
    }

    /** Test for our decodeField Method with assorted mines.*/
    @Test
    public void testDecodeField() {
        char[][] field = {
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'},
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'}
        };

        minesweeper.decodeField(field,minesweeper.myFieldNumber);

        char[][] expectedField = {
                {'2', '*', '*', '2'},
                {'*', '5', '5', '*'},
                {'3', '*', '*', '3'},
                {'*', '3', '3', '*'}
        };

        Assertions.assertArrayEquals(expectedField, field);
    }

    /** Test for the countAdjacentMines method with a 1x1 field and no mines.*/
    @Test
    public final void testCountAdjacentMines_OneDot() {
        char[][] oneByOne = {{'.'}};
        int count = minesweeper.countAdjacentMines(oneByOne, 0, 0);
        Assertions.assertEquals(0, count);
        count = minesweeper.countAdjacentMines(oneByOne, 1, 1);
        Assertions.assertEquals(0, count);
    }

    /** Test for the countAdjacentMines method with a 1x1 field and only mines.*/
    @Test
    public final void testCountAdjacentMines_OneMine() {
        char[][] oneByOne = {{'*'}};
        int count = minesweeper.countAdjacentMines(oneByOne, 0, 0);
        Assertions.assertEquals(0, count);
        count = minesweeper.countAdjacentMines(oneByOne, 1, 1);
        Assertions.assertEquals(1, count);
    }

    /** Test for the countAdjacentMines method with a 100x100 field and only mines.*/
    @Test
    public final void testCountAdjacentMines_HundredByHundred_AllMines() {
        char[][] hundredByHundred = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                hundredByHundred[i][j] = '*';
            }
        }
        int count = minesweeper.countAdjacentMines(hundredByHundred, 0, 0);
        Assertions.assertEquals(3, count);

        count = minesweeper.countAdjacentMines(hundredByHundred, 40, 35);
        Assertions.assertEquals(8, count);

        count = minesweeper.countAdjacentMines(hundredByHundred, 99, 99);
        Assertions.assertEquals(3, count);
    }

    /** Test for the countAdjacentMines method with a 100x100 field and no mines.*/
    @Test
    public final void testCountAdjacentMines_HundredByHundred_AllDots() {
        char[][] hundredByHundred = new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                hundredByHundred[i][j] = '.';
            }
        }
        int count = minesweeper.countAdjacentMines(hundredByHundred, 0, 0);
        Assertions.assertEquals(0, count);

        count = minesweeper.countAdjacentMines(hundredByHundred, 40, 35);
        Assertions.assertEquals(0, count);

        count = minesweeper.countAdjacentMines(hundredByHundred, 99, 99);
        Assertions.assertEquals(0, count);
    }

    /** Test for our countAdjacentMines Method.*/
    @Test
    public void testCountAdjacentMines() {
        char[][] field = {
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'},
                {'.', '*', '*', '.'},
                {'*', '.', '.', '*'}
        };

        int count = minesweeper.countAdjacentMines(field, 1, 1);
        assertEquals(5, count);

        count = minesweeper.countAdjacentMines(field, 0, 0);
        assertEquals(2, count);

        count = minesweeper.countAdjacentMines(field, 3, 3);
        assertEquals(1, count);
    }

    /** Test for the start method.*/
    @Test
    public void testStartEmpty() {
        // Test empty field
        String input = "0 0\n";
        Scanner scanner = new Scanner(input);
        MineSweeper mineTest = new MineSweeper(scanner);
        assertEquals(0, mineTest.myRows);
        assertEquals(1, mineTest.myFieldNumber);
    }

}

package analyse.numerique.solver;
/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import analyse.numerique.differencefinie.DefaultFunction;
import analyse.numerique.utils.LoggingExtension;

@ExtendWith(LoggingExtension.class)
public class SimpleSolverTest {
    public static String fileName = SimpleSolverTest.class.getResource("/data.txt").toExternalForm();
    public static String line = null;
    private static final double ABSOLUTE_TOLERANCE = 1e-12;
    private static final double RELATIVE_TOLERANCE = 1e-8;
    static ArrayList<Integer> none;
    static ArrayList<Integer> one;
    static ArrayList<Integer> two;
    static ArrayList<Integer> three;

    static String classeATester = "solver.SimpleSolver";

    @BeforeAll
    public static void initAll() {
        none = new ArrayList<>();
        one = new ArrayList<>();
        two = new ArrayList<>();
        three = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(
                    "C:/Users/User/Documents/java/yh/difference-finie/target/test-classes/solver/data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(" ");
                int i = Integer.parseInt(values[0]);
                int dim = Integer.parseInt(values[1]);
                switch (i) {
                case (0): {
                    none.add(dim);
                    break;
                }

                case (1): {
                    one.add(dim);
                    break;
                }

                case (2): {
                    two.add(dim);
                    break;
                }
                case (3): {
                    three.add(dim);
                    break;
                }
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            fail(ex);
        } catch (IOException ex) {
            fail(ex);
        } catch (Exception ex) {
            fail(ex);
        }

    }

    @DisplayName("Dimension 0")
    @ParameterizedTest(name = "{displayName} > {index} ===> with parameters ({arguments}) ")
    @MethodSource("none")
    public void noDimensionTest(int dim) {
        ArrayList<Double> solve = result(0, 0.0, 0, 0);
        if (solve != null)
            for (Double i : solve)
                assertTrue(Math.abs(i) < ABSOLUTE_TOLERANCE, "njunjnjn" + dim);

    }

    @DisplayName("Display name of container")
    @ParameterizedTest(name = "Fonction unité param={arguments}")
    @MethodSource("one")
    public void oneDimensionTest(int dim) {
        ArrayList<Double> result = result(dim, 0.0, 1, 1);
        if (result != null)
            for (Double i : result)
                assertTrue(Math.abs(i - 1) < RELATIVE_TOLERANCE);

    }

    @DisplayName("Display name of container")
    @ParameterizedTest(name = "fonction identité param={arguments}")
    @MethodSource("two")
    public void twoDimensionTest(int dim) {
        ArrayList<Double> result = result(dim, 0.0, 0, 1);
        if (result != null) {
            for (int i = 0; i != result.size(); i++) {
                double m = (i + 1) * 1.0 / dim - 1;
                assertTrue(m != 0.0 ? Math.abs(result.get(i) / m - 1) < RELATIVE_TOLERANCE
                        : Math.abs(result.get(i) - m) < ABSOLUTE_TOLERANCE);
            }
        }

    }

    @DisplayName("Fonction X^2")
    @ParameterizedTest(name = "Fonction X^2 param={arguments}")
    @MethodSource("three")
    public void threeDimensionTest(int dim) {
        ArrayList<Double> result = result(dim, -2.0, 0, 1);
        if (result != null) {
            for (int i = 0; i != result.size(); i++) {
                double m = Math.pow(((i + 1) * 1.0 / dim - 1), 2);
                assertTrue(m != 0.0 ? Math.abs(result.get(i) / m - 1) < RELATIVE_TOLERANCE
                        : Math.abs(result.get(i) - m) < ABSOLUTE_TOLERANCE);
            }
        }

    }

    private ArrayList<Double> result(int dim, double value, double a, double b) {
        Solver solver = new SimpleSolver();
        DefaultFunction f = new DefaultFunction(value);
        return solver.solve(dim, f.values(dim), a, b);
    }

    static ArrayList<Integer> none() {
        return none;
    }

    static ArrayList<Integer> one() {
        return one;
    }

    static ArrayList<Integer> two() {
        return two;
    }

    static ArrayList<Integer> three() {
        return three;
    }
}

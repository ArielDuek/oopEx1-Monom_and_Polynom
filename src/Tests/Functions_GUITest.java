package Tests;

import Ex1.ComplexFunction;
import Ex1.Functions_GUI;
import Ex1.function;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Functions_GUITest {
    static ComplexFunction c=new ComplexFunction();
    static LinkedList<function> listOfComplexF=new LinkedList();

    @Test
    public void initFromFile() throws IOException {
        Functions_GUI g=new Functions_GUI();
        g.initFromFile("C:/Users/tom/Desktop/function_file.txt");
        Iterator<function> iter=g.listOfComplexF.iterator();
        while(iter.hasNext())
        {
            System.out.println(iter.next().toString());
        }
        System.out.println(g.toString());

    }

    @Test
    public void saveToFile() throws IOException {
        Functions_GUI g1=new Functions_GUI();
        g1.listOfComplexF.add(c.initFromString("x^2"));
        g1.listOfComplexF.add(c.initFromString("x^2+2x"));
        g1.listOfComplexF.add(c.initFromString("plus(x^2,2x)"));
        g1.listOfComplexF.add(c.initFromString("min(plus(x^2,2x),9x^7)"));
        g1.listOfComplexF.add(c.initFromString("max(min(plus(x^2,2x),9x^7),comp(5x,7x))"));
        g1.saveToFile("C:/Users/tom/Desktop/new.txt");
    }

    @Test
    public void drawFunctions() {
    }

    @Test
    public void testDrawFunctions() {
    }
}
package ua.com.foxminded.asharov.division;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ua.com.foxminded.asharov.division.model.DivisionDTO;
import ua.com.foxminded.asharov.division.presentatoin.Plotter;


@TestInstance(Lifecycle.PER_CLASS)
class PlotterTest {
    private Plotter plotter;
    private List<Integer> indentsData;
    private List<Integer> contentsData;
    private int quotient;
    private String enterDividend;
    private String enterDivider;
    private DivisionDTO testDivisionDTO;
    private String actualResult;
    private String expectedResult;
    
    
    @BeforeAll
    public void initialization() {
        plotter = new Plotter();
    }

    @Test
    void drawDivision_shouldQuotient0Remainder0_whenInputdividend0Divider1() {
        indentsData = Arrays.asList(1);
        contentsData = Arrays.asList(0);
        quotient = 0;
        enterDividend = "0";
        enterDivider = "1";
        testDivisionDTO = new DivisionDTO(indentsData, contentsData, quotient, enterDividend, enterDivider);
        
        actualResult = plotter.drawDivision(testDivisionDTO);
        expectedResult = "_0|1\n"
                       + "  |-\n"
                       + "  |0\n";
        
        Assertions.assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void drawDivision_shouldQuotient0Remainder0_whenInputdividend1Divider100() {
        indentsData = Arrays.asList(1);
        contentsData = Arrays.asList(0);
        quotient = 0;
        enterDividend = "1";
        enterDivider = "10";
        testDivisionDTO = new DivisionDTO(indentsData, contentsData, quotient, enterDividend, enterDivider);
        
        actualResult = plotter.drawDivision(testDivisionDTO);
        expectedResult = "_1|10\n"
                       + "  |--\n"
                       + "  |0\n";
        
        Assertions.assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void drawDivision_shouldQuotient1Remainder0_whenInputdividend1Divider1() {
        indentsData = Arrays.asList(1, 1);
        contentsData = Arrays.asList(1, 1, 0);
        quotient = 1;
        enterDividend = "1";
        enterDivider = "1";
        testDivisionDTO = new DivisionDTO(indentsData, contentsData, quotient, enterDividend, enterDivider);
        
        actualResult = plotter.drawDivision(testDivisionDTO);
        expectedResult = "_1|1\n"
                       + " 1|-\n"
                       + " -|1\n"
                       + " 0\n";
        
        Assertions.assertEquals(expectedResult, actualResult);    }
    
    @Test
    void drawDivision_shouldQuotient1Remainder0_whenInputdividend100Divider100() {
        indentsData = Arrays.asList(3, 3);
        contentsData = Arrays.asList(100, 100, 0);
        quotient = 1;
        enterDividend = "100";
        enterDivider = "100";
        testDivisionDTO = new DivisionDTO(indentsData, contentsData, quotient, enterDividend, enterDivider);
        
        actualResult = plotter.drawDivision(testDivisionDTO);
        expectedResult = "_100|100\n"
                       + " 100|---\n"
                       + " ---|1\n"
                       + "   0\n";
        
        Assertions.assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void drawDivision_shouldQuotient333Remainder222_whenInputdividend111111Divider333() {
        indentsData = Arrays.asList(4, 5, 6, 6);
        contentsData = Arrays.asList(1111, 999, 1121, 999, 1221, 999, 222);
        quotient = 333;
        enterDividend = "111111";
        enterDivider = "333";
        testDivisionDTO = new DivisionDTO(indentsData, contentsData, quotient, enterDividend, enterDivider);
        
        actualResult = plotter.drawDivision(testDivisionDTO);
        expectedResult = "_111111|333\n"
                       + "  999  |---\n"
                       + "  ---  |333\n"
                       + " _1121 \n"
                       + "   999 \n"
                       + "   --- \n"
                       + "  _1221\n"
                       + "    999\n"
                       + "    ---\n"
                       + "    222\n";
        
        Assertions.assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void drawDivision_shouldQuotientNegative333Remainder222_whenInputdividendNegative111111Divider333() {
        indentsData = Arrays.asList(5, 6, 7, 7);
        contentsData = Arrays.asList(1111, 999, 1121, 999, 1221, 999, 222);
        quotient = -333;
        enterDividend = "-111111";
        enterDivider = "333";
        testDivisionDTO = new DivisionDTO(indentsData, contentsData, quotient, enterDividend, enterDivider);
                
        actualResult = plotter.drawDivision(testDivisionDTO);
        expectedResult = "_-111111|333\n"
                       + "   999  |----\n"
                       + "   ---  |-333\n"
                       + "  _1121 \n"
                       + "    999 \n"
                       + "    --- \n"
                       + "   _1221\n"
                       + "     999\n"
                       + "     ---\n"
                       + "     222\n";
        
        Assertions.assertEquals(expectedResult, actualResult);
    }

}

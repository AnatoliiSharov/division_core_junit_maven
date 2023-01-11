package ua.com.foxminded.asharov.division;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ua.com.foxminded.asharov.division.logic.EngineDivision;
import ua.com.foxminded.asharov.division.model.DivisionDTO;

@TestInstance(Lifecycle.PER_CLASS)
class EngineDivisionTest {

    private EngineDivision engineDivision;

    @BeforeAll
    public void initialization() {
        engineDivision = new EngineDivision();

    }

    @Test
    void makeDivision_shouldDepthPositionIsEmpty_whenInputDividend10Divider0() {
        Assertions.assertTrue(engineDivision.makeDivision("10", "0").getIndentsData().isEmpty());
    }

    @Test
    void makeDivision_shoulddepthPositionIsEmpty_whenInputDividendNullDivider10() {
        Assertions.assertTrue(engineDivision.makeDivision(null, "10").getIndentsData().isEmpty());
    }

    @Test
    void makeDivision_shoulddepthPositionIsEmpty_whenInputDividend10DividerNull() {
        Assertions.assertTrue(engineDivision.makeDivision("10", null).getIndentsData().isEmpty());
    }

    @Test
    void makeDivision_shouldQuotient0Remainder0_whenInputDividend0Divider10() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("0", "10");

        Assertions.assertAll("whenInputDividend0Divider10",
                () -> assertEquals(Arrays.asList(1), (divisionDTO.getIndentsData())),
                () -> assertEquals(Arrays.asList(0), divisionDTO.getContentsData()),
                () -> assertEquals(0, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_shouldQuotient0Remainder1_whenInputDividend1Divider10() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("1", "10");

        Assertions.assertAll("whenInputDividend1Divider10",
                () -> assertEquals(Arrays.asList(1), (divisionDTO.getIndentsData())),
                () -> assertEquals(Arrays.asList(1), divisionDTO.getContentsData()),
                () -> assertEquals(0, (divisionDTO.getQuotient())));
    }
    
    @Test
    void makeDivision_shouldQuotient0RemainderNegativ1_whenInputDividendNegative1Divider10() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("-1", "10");
        
        Assertions.assertAll("whenInputDividendNegative1Divider10",
                () -> assertEquals(Arrays.asList(2), (divisionDTO.getIndentsData())),
                () -> assertEquals(Arrays.asList(1), divisionDTO.getContentsData()),
                () -> assertEquals(0, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_shouldQuotient1Remainder0_whenInputDividend1Divider1() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("1", "1");
        
        Assertions.assertAll("whenInputDividend1Divider1",
                () -> assertEquals(Arrays.asList(1, 1), (divisionDTO.getIndentsData())),
                () -> assertEquals(Arrays.asList(1, 1, 0), divisionDTO.getContentsData()),
                () -> assertEquals(1, (divisionDTO.getQuotient())));
    }
    
    @Test
    void makeDivision_shouldQuotient100Remainder0_whenInputDividend10Divider1() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("100", "1");
        
        Assertions.assertAll("whenInputDividend1Divider10",
                () -> assertEquals(Arrays.asList(1, 3), (divisionDTO.getIndentsData())),
                () -> assertEquals(Arrays.asList(1, 1, 0), divisionDTO.getContentsData()),
                () -> assertEquals(100, (divisionDTO.getQuotient())));
    }
    
    @Test
    void makeDivision_shouldQuotient7Remainder0_whenInputDividend21Divider3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("21", "3");

        Assertions.assertAll("whenInputDividend21Divider3",
                () -> assertEquals(Arrays.asList(2, 2), (divisionDTO.getIndentsData())),
                () -> assertEquals(Arrays.asList(21, 21, 0), divisionDTO.getContentsData()),
                () -> assertEquals(7, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_shouldQuotient7Remainder1_whenInputDividend22Divider3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("22", "3");

        Assertions.assertAll("whenInputDividend22Divider3",
                () -> assertEquals(Arrays.asList(2, 2), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(22, 21, 1), divisionDTO.getContentsData()),
                () -> assertEquals(7, divisionDTO.getQuotient()));
    }

    @Test
    void shouldQuotient70Remainder0_whenInputDividend210Divider3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("210", "3");

        Assertions.assertAll("whenInputDividend210Divider3",
                () -> assertEquals(Arrays.asList(2, 3), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(21, 21, 0),
                        divisionDTO.getContentsData()),
                () -> assertEquals(70, (divisionDTO.getQuotient())));
    }

    @Test
    void shouldQuotient700Remainder0_whenInputDividend2100Divider3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("2100", "3");

        Assertions.assertAll("whenInputDividend2100Divider3",
                () -> assertEquals(Arrays.asList(2, 4), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(21, 21, 0),
                        divisionDTO.getContentsData()),
                () -> assertEquals(700, (divisionDTO.getQuotient())));
    }

    @Test
    void shouldQuotient70Remainder1_whenInputDividend211Divider3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("211", "3");

        Assertions.assertAll("whenInputDividend211Divider3",
                () -> assertEquals(Arrays.asList(2, 3), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(21, 21, 1),
                        divisionDTO.getContentsData()),
                () -> assertEquals(70, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_shouldQuotient70Remainder11_whenInputDividend2111Divider30() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("2111", "30");

        Assertions.assertAll("whenInputDividend2111Divider30",
                () -> assertEquals(Arrays.asList(3, 4), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(211, 210, 11), divisionDTO.getContentsData()),
                () -> assertEquals(70, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_shouldQuotient1Remainder1111_whenInputDividend4111Divider3000() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("4111", "3000");

        Assertions.assertAll("whenInputDividend4111Divider3000",
                () -> assertEquals(Arrays.asList(4, 4), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(4111, 3000, 1111), divisionDTO.getContentsData()),
                () -> assertEquals(1, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_sholdQuotient707Remainder0_whenInputDividend2121Divider3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("2121", "3");

        Assertions.assertAll("whenInputDividend2121Divider3",
                () -> assertEquals(Arrays.asList(2, 4, 4), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(21, 21, 21, 21, 0), divisionDTO.getContentsData()),
                () -> assertEquals(707, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_sholdQuotient7007Remainder0_whenInputDividend21021Divider3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("21021", "3");

        Assertions.assertAll("whenInputDividend21021Divider3",
                () -> assertEquals((Arrays.asList(2, 5, 5)), (divisionDTO.getIndentsData())),
                () -> assertEquals(Arrays.asList(21, 21, 21, 21, 0), divisionDTO.getContentsData()),
                () -> assertEquals(7007, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_sholdQuotientNegative7007Remainder0_whenInputDividendNegative21021Divider3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("-21021", "3");

        Assertions.assertAll("whenInputDividend21021Divider3",
                () -> assertEquals(Arrays.asList(3, 6, 6), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(21, 21, 21, 21, 0), divisionDTO.getContentsData()),
                () -> assertEquals(-7007, (divisionDTO.getQuotient())));
    }

    @Test
    void makeDivision_sholdQuotientNegative7007Remainder0_whenInputDividend21021DividerNegative3() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("21021", "-3");

        Assertions.assertAll("whenInputDividend21021Divider3",
                () -> assertEquals(Arrays.asList(2, 5, 5), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(21, 21, 21, 21, 0), divisionDTO.getContentsData()),
                () -> assertEquals(-7007, divisionDTO.getQuotient()));
    }
    
    @Test
    void makeDivision_sholdQuotientNegative333Remainder222_whenInputDividend111111DividerNegative333() {
        DivisionDTO divisionDTO = engineDivision.makeDivision("111111", "333");
        
        Assertions.assertAll("whenInputDividend21021Divider3",
                () -> assertEquals(Arrays.asList(4, 5, 6, 6), divisionDTO.getIndentsData()),
                () -> assertEquals(Arrays.asList(1111, 999, 1121, 999, 1221, 999, 222), divisionDTO.getContentsData()),
                () -> assertEquals(333, divisionDTO.getQuotient()));
    }

}

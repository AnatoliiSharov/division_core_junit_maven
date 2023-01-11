package ua.com.foxminded.asharov.division.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.com.foxminded.asharov.division.model.DivisionDTO;

public class EngineDivision {

    public DivisionDTO makeDivision(String enterDividend, String enterDivider) {
        StringBuilder quotient = new StringBuilder("0");
        int basicIndent = 1;

        if (enterDividend == null || enterDivider == null || Integer.parseInt(enterDivider) == 0) {
            System.out.println("The entered data is wrong");
            return new DivisionDTO(new ArrayList<>());
        }

        if (isOneIfMinus(enterDividend) != isOneIfMinus(enterDivider)) {
            quotient.insert(0, "-");
        }
        basicIndent += isOneIfMinus(enterDividend);

        return makeLongDivision(enterDividend, enterDivider, basicIndent, quotient);
    }

    private DivisionDTO makeLongDivision(String enterDividend, String enterDivider, int basicIndent,
            StringBuilder quotient) {
        List<Integer> indentsData = new ArrayList<>();
        List<Integer> contentsData = new ArrayList<>();
        List<Integer> numersDividend = new ArrayList<>();
        int divider = Integer.parseInt(removeMinus(enterDivider));
        int current;

        for (String str : Arrays.asList(removeMinus(enterDividend).split(""))) {
            numersDividend.add(Integer.parseInt(str));
        }
        current = numersDividend.get(0);

        for (int indent = 0; indent <= numersDividend.size() - 1;) {
            int previousIndent = indent;

            for (; current < divider; indent++) {

                if (indent >= numersDividend.size() - 1) {
                    break;
                }
                current = current * 10 + numersDividend.get(indent + 1);
            }

            if (current >= divider) {
                
                if (current > divider) {
                    quotient.append("0".repeat(indent - previousIndent - 1));
                }
                quotient.append(current / divider);
                indentsData.add(indent + basicIndent);
                contentsData.add(current);
                contentsData.add(divider * (current / divider));
                current = current - divider * (current / divider);
            } else {
                quotient.append("0".repeat(indent - previousIndent));
                indentsData.add(indent + basicIndent);
                contentsData.add(current);
                break;
            }
        }
        return new DivisionDTO(indentsData, contentsData, convertToInteger(quotient), enterDividend, enterDivider);
    }

    private int convertToInteger(StringBuilder quotient) {

        if ("-".equals(quotient.toString()) || "".equals(quotient.toString())) {
            return 0;
        } else {
            return Integer.parseInt(quotient.toString());
        }
    }

    private String removeMinus(String someThing) {

        if (isOneIfMinus(someThing) == 1) {
            someThing = someThing.substring(1);
        }
        return someThing;
    }

    private int isOneIfMinus(String enterDividend) {
        if (enterDividend.charAt(0) == '-') {
            return 1;
        } else {
            return 0;
        }
    }

}

package ua.com.foxminded.asharov.division.presentatoin;

import java.util.List;

import ua.com.foxminded.asharov.division.model.DivisionDTO;

public class Plotter {

    public String drawDivision(DivisionDTO divisionDTO) {
        StringBuilder result = new StringBuilder();
        List<Integer> contentsData = divisionDTO.getContentsData();
        List<Integer> indentsData = divisionDTO.getIndentsData();
        int quotient = divisionDTO.getQuotient();
        String enterDividend = divisionDTO.getEnterDividend();
        String enterDivider = divisionDTO.getEnterDivider();
        int amountLineDraw = 3 * indentsData.size() - 2;
        int insteadLowerDash = 1;

        if (indentsData.isEmpty()) {
            return "the necessary data is missing";
        }

        for (int i = 0; i < Math.max(amountLineDraw, 3); i++) {
            StringBuilder nextLines = new StringBuilder();

            nextLines.append(stuffSpace(enterDividend.length() + insteadLowerDash))
                    .append(chooseTailFirstLines(i, enterDivider, quotient)).append("\n");

            if (i <= amountLineDraw - 1) {
                nextLines.replace(
                        (insteadLowerDash + indentsData.get(i / 3)) - choosePartShotDivision(i, contentsData).length(),
                        (insteadLowerDash + indentsData.get(i / 3)), choosePartShotDivision(i, contentsData));
            }
            result.append(nextLines);
        }

        return result.replace(0, insteadLowerDash + enterDividend.length(), "_".concat(enterDividend)).toString();
    }

    private String choosePartShotDivision(int step, List<Integer> contentsData) {
        StringBuilder result = new StringBuilder("");
        int i = step - 3 * (step / 3);
        int content = 2 * (step / 3) + i;

        if (i == 0) {
            result.append((putUndeline(content, contentsData.size()))).append((contentsData.get(content)).toString());
        } else if (i == 1) {
            result.append(contentsData.get(content)).toString();
        } else if (i == 2) {
            result.append(stuffDash(Integer.toString(contentsData.get(content - 1)).length())).toString();
        } else {
            System.out.println("who are you!?");
        }
        return result.toString();
    }

    private String chooseTailFirstLines(int i, String enterDivider, int quotient) {
        StringBuilder result = new StringBuilder("");

        if (i == 0) {
            result.append("|").append(enterDivider);
        } else if (i == 1) {
            result.append("|").append(stuffDash(Math.max(Integer.toString(quotient).length(), enterDivider.length())));
        } else if (i == 2) {
            result.append("|").append(Integer.toString(quotient));
        }
        return result.toString();
    }

    private String putUndeline(int step, int length) {
        if (step == length - 1) {
            return " ";
        } else {
            return "_";
        }
    }

    private String stuffSpace(int lengthSpaces) {
        StringBuilder spaceLine = new StringBuilder();

        for (int i = 0; i < lengthSpaces; i++) {
            spaceLine.append(" ");
        }
        return spaceLine.toString();
    }

    private String stuffDash(int lengthDash) {
        StringBuilder dishLine = new StringBuilder();

        for (int i = 0; i < lengthDash; i++) {
            dishLine.append("-");
        }
        return dishLine.toString();
    }

}

package ua.com.foxminded.asharov.division.model;

import java.util.List;

public class DivisionDTO {
    private List<Integer> indentsData;
    private List<Integer> contentsData;
    private int quotient;
    private String enterDividend;
    private String enterDivider;

    public DivisionDTO(List<Integer> indentsData, List<Integer> contentsData, int quotient,
            String enterDividend, String enterDivider) {
        this.indentsData = indentsData;
        this.contentsData = contentsData;
        this.quotient = quotient;
        this.enterDividend = enterDividend;
        this.enterDivider = enterDivider;
    }

    public DivisionDTO(List<Integer> indentsData) {
        this.indentsData = indentsData;
    }

    public List<Integer> getIndentsData() {
        return indentsData;
    }

    public List<Integer> getContentsData() {
        return contentsData;
    }

    public int getQuotient() {
        return quotient;
    }

    public String getEnterDividend() {
        return enterDividend;
    }

    public String getEnterDivider() {
        return enterDivider;
    }

    public void setIndentsData(List<Integer> indentsData) {
        this.indentsData = indentsData;
    }

    public void setContentsData(List<Integer> contentPosition) {
        this.contentsData = contentPosition;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public void setEnterDividend(String enterDividend) {
        this.enterDividend = enterDividend;
    }

    public void setEnterDivider(String enterDivider) {
        this.enterDivider = enterDivider;
    }

}

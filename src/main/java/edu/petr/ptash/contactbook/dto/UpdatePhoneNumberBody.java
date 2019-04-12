package edu.petr.ptash.contactbook.dto;

public class UpdatePhoneNumberBody {
    private String operatorName;
    private String number;

    public UpdatePhoneNumberBody(String operatorName, String number) {
        this.operatorName = operatorName;
        this.number = number;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

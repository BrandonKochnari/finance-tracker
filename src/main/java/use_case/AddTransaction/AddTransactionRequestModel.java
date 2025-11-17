package use_case.AddTransaction;

import java.util.Date;

public class AddTransactionRequestModel {
    private float amount;
    private String note;
    private String type;
    private Date date;

    public AddTransactionRequestModel(float amount, String note, String type, Date date) {
        this.amount = amount;
        this.note = note;
        this.type = type;
    }
    public float get_amount(){
        return amount;
    }
    public String get_type(){
        return type;
    }

    public String get_note(){
        return note;
    }

    public Date get_date(){
        return date;
    }
}

package udemy.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private Double dailyIncome;
    private Integer days;
    private Double total;

    public Payment(String name, double dailyIncome, int days) {
        super();
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
        this.total = this.getTotal();
    }

    public double getTotal(){
        return this.days * this.dailyIncome;
    }
}

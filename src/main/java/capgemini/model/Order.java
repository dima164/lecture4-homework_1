package capgemini.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Order {

    private int id;

    private List<OrderItem> items;

    private PromoCode promoCode;

    public double getTotalPrice() {
        double sum = 0;
        for (OrderItem orderItem : items) {
            sum += orderItem.getProduct().getPrice() * orderItem.getAmount();
        }
        if (promoCode != null && promoCode.isActive()) {
            sum *= (1 - promoCode.getDiscount() / 100);
        }

        return sum;
    }
}

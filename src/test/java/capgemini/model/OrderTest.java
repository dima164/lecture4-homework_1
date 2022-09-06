package capgemini.model;

import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.web.servlet.tags.form.AbstractSingleCheckedElementTag;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    Order order;

    @BeforeEach
    void setup() {
        order = new Order();
    } // construit cu constructorul defoult - no arguments

    Product prod1 = new Product(1, "apple", "", 4.5);
    OrderItem orderItem1 = new OrderItem(1, prod1, 3);

    Product prod2 = new Product(2, "banana", "", 5.0);
    OrderItem orderItem2 = new OrderItem(1, prod2, 3);

    Product prod3 = new Product(1, "orange", "", 5.5);
    OrderItem orderItem3 = new OrderItem(1, prod3, 3);


    List<OrderItem> orderItemList = List.of(orderItem1, orderItem2, orderItem3);

    // TODO check total price
    @Test
    void getTotalPrice_multipleItems_success_without_promoCode() {

        order.setItems(orderItemList);

        double totPriceWithoutPromoCode = order.getTotalPrice();

        assertEquals(45, totPriceWithoutPromoCode);
    }

    PromoCode promoCode = new PromoCode(1, "", 30, true, null);

    @Test
    void getTotalPrice_multipleItems_succes_with_promoCode() {

        order.setItems(orderItemList);

         // add to Order -> not null PromoCode witch in first test method because Order was created thrue
        // no args.constructor , initial was null
        order.setPromoCode(promoCode);

        double totPriceWithPromoCode = order.getTotalPrice();

        assertEquals(31.499999999999996, totPriceWithPromoCode);
    }
}
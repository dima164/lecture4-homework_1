package capgemini.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PromoCode {

    private int id;

    private String promo;

    private double discount; // the dicount is for ex. 30 means a 30% reduction

    private boolean active;

    private LocalDateTime validUntil;
}

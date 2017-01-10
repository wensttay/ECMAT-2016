package io.github.herocode.ecmat.enums;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public enum PaymentStatus {

    AWAITING_PAYMENT("1"),
    IN_REVIEW("2"),
    COMPLETE("3"),
    AVAILABLE("4"),
    IN_DISPUTE("5"),
    RETURNED("6"),
    CANCELLED("7");

    String code;

    PaymentStatus(String paymentCode) {
        code = paymentCode;
    }

    public String getCode() {
        return code;
    }

}

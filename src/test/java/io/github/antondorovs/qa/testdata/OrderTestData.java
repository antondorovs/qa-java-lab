package io.github.antondorovs.qa.testdata;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderTestData(String customerName, String customerEmail, BigDecimal total) {
    public static OrderTestData newOrder() {
        return new OrderTestData("Alex Morgan", "qa-" + UUID.randomUUID() + "@example.com",
                new BigDecimal("49.95"));
    }
}

package io.github.antondorovs.qa.models;

import java.math.BigDecimal;

public record ProductRequest(String title, String description, BigDecimal price, String category) {
}

package io.github.antondorovs.qa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Product(int id, String title, String description, BigDecimal price, String category) {
}

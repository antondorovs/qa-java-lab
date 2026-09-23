package io.github.antondorovs.qa.models;

import java.util.List;

public record ProductsResponse(List<Product> products, int total, int skip, int limit) {
}

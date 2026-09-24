package io.github.antondorovs.qa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductCategory(String slug, String name, String url) {
}

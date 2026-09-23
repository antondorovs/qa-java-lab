package io.github.antondorovs.qa.api;

import io.github.antondorovs.qa.models.ProductRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductsClient {
    public Response getProduct(int id) {
        return given().spec(ApiSpecifications.request()).get("/products/{id}", id);
    }

    public Response listProducts(int limit, int skip) {
        return given().spec(ApiSpecifications.request())
                .queryParam("limit", limit).queryParam("skip", skip).get("/products");
    }

    public Response searchProducts(String query) {
        return given().spec(ApiSpecifications.request())
                .queryParam("q", query).get("/products/search");
    }

    public Response getProductsByCategory(String category) {
        return given().spec(ApiSpecifications.request()).get("/products/category/{category}", category);
    }

    public Response createProduct(ProductRequest product) {
        return given().spec(ApiSpecifications.request()).body(product).post("/products/add");
    }

    public Response updateProduct(int id, ProductRequest product) {
        return given().spec(ApiSpecifications.request()).body(product).patch("/products/{id}", id);
    }

    public Response deleteProduct(int id) {
        return given().spec(ApiSpecifications.request()).delete("/products/{id}", id);
    }
}

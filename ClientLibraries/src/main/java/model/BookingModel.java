package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martha on 3/2/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSubTypes({ @JsonSubTypes.Type(value = BookingProduct.class, name = "products") })
public class BookingModel {

    private List<BookingProduct> products;
    private Integer userId;
    private Integer restaurantId;
    private String restaurantName;
    private String userName;
    private Integer reservationId;

    public BookingModel() {
    }

    public BookingModel(List<BookingProduct> products, Integer userId, Integer restaurantId, Integer reservationId) {
        this.products = products;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.reservationId = reservationId;
    }

    public BookingModel(@JsonProperty("products") List<BookingProduct> products,
                        @JsonProperty("userId") Integer userId,
                        @JsonProperty("restaurantId") Integer restaurantId,
                        @JsonProperty("restaurantName") String restaurantName,
                        @JsonProperty("reservationId") Integer reservationId,
                        @JsonProperty("userName") String userName) {
        this.products = products;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.reservationId = reservationId;
        this.userName = userName;
    }

    public List<BookingProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BookingProduct> products) {
        this.products = products;
    }

    public void setProduct(BookingProduct product) {
        if(this.products == null) this.products = new ArrayList<>();
        products.add(product);
    }

    public void setProduct(Integer productId, int quantity) {
        if(this.products == null) this.products = new ArrayList<>();
        products.add(new BookingProduct(productId, quantity));
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

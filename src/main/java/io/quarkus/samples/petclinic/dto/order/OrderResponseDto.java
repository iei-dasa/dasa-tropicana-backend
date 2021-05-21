package io.quarkus.samples.petclinic.dto.order;


import java.time.LocalDate;
import java.util.List;

public class OrderResponseDto {
    private Long id;
    private Double totalPrice;
    private LocalDate date;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String email;
    private String phoneNumber;
    private Integer postIndex;
    private List<OrderItemResponseDto> orderItems;
}

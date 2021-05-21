package io.quarkus.samples.petclinic.dto.order;

import io.quarkus.samples.petclinic.dto.perfume.PerfumeResponseDto;

public class OrderItemResponseDto {
    private Long id;
    private Long amount;
    private Long quantity;
    private PerfumeResponseDto perfume;
}

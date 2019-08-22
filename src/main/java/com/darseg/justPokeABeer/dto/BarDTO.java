package com.darseg.justPokeABeer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BarDTO {

    private Long id;

    private String name;

    private String address;

    private BarScheduleDTO schedule;

    private List<BarContactsDTO> contacts;

    private List<String> images;

    public BarDTO(final Long id, final String name, final String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public BarDTO(final String name, final String address) {
        this.name = name;
        this.address = address;
    }
}

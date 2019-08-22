package com.darseg.justPokeABeer.dto;

import com.darseg.justPokeABeer.enums.ContactType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BarContactsDTO {
    private ContactType type;

    private String contact;

    private String description;
}

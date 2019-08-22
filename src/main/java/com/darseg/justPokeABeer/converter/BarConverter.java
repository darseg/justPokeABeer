package com.darseg.justPokeABeer.converter;

import com.darseg.justPokeABeer.dbo.BarContactDBO;
import com.darseg.justPokeABeer.dbo.BarDBO;
import com.darseg.justPokeABeer.dbo.BarImagesDBO;
import com.darseg.justPokeABeer.dbo.BarScheduleDBO;
import com.darseg.justPokeABeer.dto.BarContactsDTO;
import com.darseg.justPokeABeer.dto.BarDTO;
import com.darseg.justPokeABeer.dto.BarScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarConverter extends AbstractConverter<BarDBO, BarDTO> {
    @Override
    public BarDTO convertToDto(final BarDBO barDBO) {
        final BarDTO barDTO = new BarDTO(barDBO.getBid(), barDBO.getName(), barDBO.getAddress());

        final List<BarContactDBO> contacts = barDBO.getContacts();
        if (!contacts.isEmpty()) {
            final List<BarContactsDTO> contactsNew = new ArrayList<>();
            barDTO.setContacts(contactsNew);

            barDBO.getContacts().forEach(barContactDBO -> contactsNew.add(new BarContactsDTO(barContactDBO.getType(), barContactDBO.getContact(), barContactDBO.getDescription())));
        }

        final List<BarScheduleDBO> schedules = barDBO.getSchedules();
        if (!schedules.isEmpty()) {
            final BarScheduleDTO schedule = new BarScheduleDTO();
            barDTO.setSchedule(schedule);

            schedules.forEach(barScheduleDBO -> schedule.addDay(barScheduleDBO.getDayOfWeek(), barScheduleDBO.getOpen(), barScheduleDBO.getClose()));
        }

        final List<BarImagesDBO> images = barDBO.getImages();
        if (!images.isEmpty()) {
            final List<String> newImages = new ArrayList<>();
            barDTO.setImages(newImages);

            images.forEach(barImagesDBO -> newImages.add(barImagesDBO.getImageURL()));
        }

        return barDTO;
    }

    @Override
    public BarDBO convertToDbo(BarDTO barDTO) {
        final BarDBO barDBO = new BarDBO();

        barDBO.setName(barDTO.getName());
        barDBO.setAddress(barDTO.getAddress());
        if (barDTO.getContacts() != null) {
            final List<BarContactDBO> newContacts = barDBO.getContacts();
            barDTO.getContacts().forEach(barContactsDTO -> {
                final BarContactDBO barContactDBO = new BarContactDBO();
                barContactDBO.setType(barContactsDTO.getType());
                barContactDBO.setContact(barContactsDTO.getContact());
                barContactDBO.setDescription(barContactsDTO.getDescription());
                barContactDBO.setBar(barDBO);
                newContacts.add(barContactDBO);
            });
        }

        if (barDTO.getImages() != null) {
            final List<BarImagesDBO> newImages = barDBO.getImages();
            barDTO.getImages().forEach(s -> {
                final BarImagesDBO barImagesDBO = new BarImagesDBO();
                barImagesDBO.setImageURL(s);
                barImagesDBO.setBar(barDBO);
                newImages.add(barImagesDBO);
            });
        }
        if (barDTO.getSchedule() != null) {
            final List<BarScheduleDBO> newSchedules = barDBO.getSchedules();
            barDTO.getSchedule().getDaySchedules().forEach(daySchedule -> {
                final BarScheduleDBO barScheduleDBO = new BarScheduleDBO();
                barScheduleDBO.setDayOfWeek(daySchedule.getDay());
                barScheduleDBO.setOpen(daySchedule.getOpen());
                barScheduleDBO.setClose(daySchedule.getClose());
                barScheduleDBO.setBar(barDBO);
                newSchedules.add(barScheduleDBO);
            });
        }
        return barDBO;
    }
}

package com.socialwelfareportal.socialwelfareportal.dto.responsedto;

import com.socialwelfareportal.socialwelfareportal.entity.Events;
import com.socialwelfareportal.socialwelfareportal.entity.NgoDetails;
import com.socialwelfareportal.socialwelfareportal.entity.VolunteerDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDto {
    private Integer id;
    private String name;
    private String date;
    private String eventLocation;
    private String description;
    private Integer fund;
    private List<NgoDetails> ngo;
    private List<VolunteerDetails> volunteers;

    public EventResponseDto(Events events){
        this.id=events.getId();
        this.name=events.getName();
        this.eventLocation=events.getEventLocation();
        this.description=events.getDescription();
        this.fund=events.getFund();
        this.date = new SimpleDateFormat().format(events.getDatename());
        this.ngo=events.getNgos();
        this.volunteers=events.getVolunteer();
    }
}

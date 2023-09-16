package com.socialwelfareportal.socialwelfareportal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date datename;
    @Column(name = "event_location")
    private String eventLocation;
    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "ngo_events",
    joinColumns = {@JoinColumn(name="event_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "ngo_id", referencedColumnName = "id")})
    private List<NgoDetails> ngos;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "event_volunteers",
            joinColumns = {@JoinColumn(name="event_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "volunteer_id", referencedColumnName = "id")})
    private List<VolunteerDetails> volunteer;

    @OneToMany(mappedBy = "events", cascade = CascadeType.ALL)
    private List<UploadDetails> uploadDetails;
}

package hr.neos.aleksaeventmanager.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
    @SequenceGenerator(name = "event_sequence", allocationSize = 10)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private Integer maxParticipants;

    @Column
    private Date registrationsNotBefore;

    @Column
    private Date registrationsNotAfter;

    @Column
    private Date confirmationNotAfter;

    @Column
    private Date startDate;

    @Column
    private Integer weeks;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.ALL})
    private List<Team> teams;

    @OneToMany(mappedBy = "event", cascade = {CascadeType.ALL})
    private List<Registration> registrations;

}

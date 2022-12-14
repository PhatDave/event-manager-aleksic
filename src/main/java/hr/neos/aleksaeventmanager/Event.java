package hr.neos.aleksaeventmanager;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "event_sequence")
    @SequenceGenerator(name = "event_sequence", allocationSize=10)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private Integer maxParticipants;

    /*@OneToMany(mappedBy = "event")
    private List<Team> teams;*/

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

}

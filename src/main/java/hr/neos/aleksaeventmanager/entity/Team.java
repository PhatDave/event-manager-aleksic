package hr.neos.aleksaeventmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="teams")
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="team_sequence")
    @SequenceGenerator(name="team_sequence", allocationSize=10)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy="team", cascade = CascadeType.ALL)
    private List<Mentor> mentors;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="eventId")
    private Event event;
}

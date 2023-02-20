package hr.neos.aleksaeventmanager.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "mentors")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_sequence")
    @SequenceGenerator(name = "mentor_sequence", allocationSize = 10)
    private Long id;

    @Column
    private String email;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teamId")
    private Team team;
}

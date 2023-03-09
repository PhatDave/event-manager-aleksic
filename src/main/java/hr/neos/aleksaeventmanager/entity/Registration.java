package hr.neos.aleksaeventmanager.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_sequence")
    @SequenceGenerator(name = "registration_sequence", allocationSize = 10)
    private Long id;

    @Column
    private String uuid;

    @OneToOne(mappedBy = "registration", cascade = CascadeType.ALL)
    private User user;

    @JoinColumn(name = "eventId")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Event event;

}

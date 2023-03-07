package hr.neos.aleksaeventmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OtherUserInfo {

    @Column
    private String summary;

    @Column
    private String motivation;

    @Column
    private String preferredOS;
}

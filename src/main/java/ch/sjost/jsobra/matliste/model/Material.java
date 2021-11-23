package ch.sjost.jsobra.matliste.model;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Material {

    @Getter @Setter
    private @Id @GeneratedValue Long id;

    @NonNull @Getter @Setter
    private String title;

    @NonNull @Getter @Setter
    private String category;

    @NonNull @Getter @Setter
    private int amountOf;

    @NonNull @Getter @Setter
    private String storingPlace;

    @NonNull @Getter @Setter
    private String description;


}

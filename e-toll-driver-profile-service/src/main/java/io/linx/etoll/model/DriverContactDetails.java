package io.linx.etoll.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by lingani on 3/25/17.
 */
@AllArgsConstructor
@NoArgsConstructor
public class DriverContactDetails {

    @Getter @Setter
    private Integer driverId;

    @Getter @Setter
    private String address;
}

package io.linx.etoll.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by lingani on 2017/02/15.
 */
public class Rate {

    @Getter
    @Setter
    private String lanecount;

    @Getter
    @Setter
    private String tollstart;

    @Getter
    @Setter
    private String rate;

    @Getter
    @Setter
    private String connstring;
}

package io.linx.etoll.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by lingani on 2017/03/14.
 */
@AllArgsConstructor
@NoArgsConstructor
public class ETollUsage {

    public String Id;
    public String stationId;
    public String licensePlate;
    public String timestamp;
}

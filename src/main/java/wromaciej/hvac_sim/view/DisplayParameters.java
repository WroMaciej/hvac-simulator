package wromaciej.hvac_sim.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "simulation")
public class DisplayParameters {

    @Id
    @Column(name = "id")
    private Integer displayParametersId;
    @Column(name = "angle")
    private Double angle;
    @Column(name = "scale")
    private Double scale;
    @Column(name = "position_x")
    private Double positionX;
    @Column(name = "position_y")
    private Double positionY;
}

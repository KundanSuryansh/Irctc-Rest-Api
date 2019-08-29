package com.kundan.railticket.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="stationId")
public class Station implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long stationId;

    private String name;

    @OneToMany(mappedBy = "station")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<TrainStation> trainStationList;

    Station(){}
    public Station(String name, List<TrainStation> trainStationList) {
        this.name = name;
        this.trainStationList = trainStationList;
    }

    public long getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public List<TrainStation> getTrainStationList() {
        return trainStationList;
    }
}

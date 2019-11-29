package com.eliseev.app.services.dto;

import com.eliseev.app.models.Train;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TrainDateDTO {

    private Long trainId;
    private long[] dateIds;
    private String trainName;
}

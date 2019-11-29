package com.eliseev.app.service;

import com.eliseev.app.db.dao.TestConfig;
import com.eliseev.app.models.TrainDate;
import com.eliseev.app.models.TrainRoutePiece;
import com.eliseev.app.services.StationStopTimeService;
import com.eliseev.app.services.TrainDateService;
import com.eliseev.app.services.TrainService;
import com.eliseev.app.services.TrainRoutePieceService;
import com.eliseev.app.services.dto.StationStopTimeDTO;
import com.eliseev.app.services.dto.TrainRouteDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class TrainDateServiceTest {

    Logger logger = LoggerFactory.getLogger(TrainDateServiceTest.class);

    @Autowired
    private TrainDateService trainDateService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainRoutePieceService trainRoutePieceService;

    @Autowired
    private StationStopTimeService stationStopTimeService;

    @Test
    @Transactional
    public void getDates() {
        List<TrainRouteDTO> trainDateDTOS = trainDateService.getDates(1);
        assertNotNull(trainDateDTOS);
        logger.info("{}", trainDateDTOS);
    }

    @Test
    @Transactional
    public void createTrainDate() {

        List<TrainRoutePiece> trainRoutePieces = trainRoutePieceService.list(1L);

        StationStopTimeDTO stationStopTimeDTO;
        List<StationStopTimeDTO> stationStopTimeDTOs = new ArrayList<>();
        for (TrainRoutePiece trainRoutePiece : trainRoutePieces) {
            stationStopTimeDTO = new StationStopTimeDTO(trainRoutePiece.getId(), new Date(), new Date());
            stationStopTimeDTOs.add(stationStopTimeDTO);
        }

        TrainDate trainDate =  trainDateService.create(stationStopTimeDTOs, 1L);

        logger.info("{}",trainDate);
        logger.info("{}", trainDate.getStationStopTimes());

    }


}

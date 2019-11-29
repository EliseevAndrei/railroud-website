package com.eliseev.app.services;

import com.eliseev.app.models.Station;
import com.eliseev.app.models.Train;
import com.eliseev.app.models.TrainDate;
import com.eliseev.app.models.TrainRoutePiece;
import com.eliseev.app.repository.custom.TrainDAO;
import com.eliseev.app.services.dto.TrainDateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class TrainService extends AbstractService<Train, TrainDAO> {

    private StationService stationService;
    private Logger logger = LoggerFactory.getLogger(TrainService.class);

    @Autowired
    public TrainService(TrainDAO dao,
                        StationService stationService) {
        super(dao);
        this.stationService = stationService;
    }

    @Transactional
    public Train create(Train train) {
        if (train.getTrainRoutePieceList().size() > 0) {
            for (TrainRoutePiece trainRoutePiece : train.getTrainRoutePieceList()) {
                trainRoutePiece.setTrain(train);
            }
        }
        return super.dao.save(train);
    }

    @Transactional
    public List<Train> getTrainsOnStations(String depStation, String arrStation, Date date) {
        logger.info("find trains with stations {}, - {} at date {}", depStation, arrStation, date);
        return super.list();
    }

    @Transactional
    public List<TrainRoutePiece> createRoute(List<TrainRoutePiece> trainRoutePieces, long trainId) {

        Train train = super.dao.findOne(trainId);

        trainRoutePieces.forEach(e -> {
            e.setTrain(train);
        });

        train.getTrainRoutePieceList().addAll(trainRoutePieces);

        return null;
    }



}

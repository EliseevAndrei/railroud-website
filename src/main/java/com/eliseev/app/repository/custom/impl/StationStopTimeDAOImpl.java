package com.eliseev.app.repository.custom.impl;

import com.eliseev.app.models.StationStopTime;
import com.eliseev.app.repository.AbstractDAO;
import com.eliseev.app.repository.custom.StationStopTimeDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class StationStopTimeDAOImpl extends AbstractDAO<StationStopTime>
        implements StationStopTimeDAO {

    public StationStopTimeDAOImpl() {
        super(StationStopTime.class);
    }

    @Override
    public List<StationStopTime> findStationsStopTimeByTrainDateId(Long id) {
        return super.entityManager.createQuery("select s from StationStopTime s where s.trainDate.id = :id", StationStopTime.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public StationStopTime getStopTimeByTrainRouteIdAndTrainDateId(long trainRouteId, long trainDateId) {
        try{
            return super.entityManager.createQuery("select s from StationStopTime s where s.trainRoutePiece.id = :trainRouteId and s.trainDate.id = :trainDateId", StationStopTime.class)
                    .setParameter("trainRouteId", trainRouteId)
                    .setParameter("trainDateId", trainDateId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


}

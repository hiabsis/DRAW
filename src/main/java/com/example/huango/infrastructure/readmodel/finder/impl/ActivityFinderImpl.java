package com.example.huango.infrastructure.readmodel.finder.impl;

import com.example.huango.domain.QActivity;
import com.example.huango.infrastructure.readmodel.dto.ActivityDTO;
import com.example.huango.infrastructure.readmodel.finder.ActivityFinder;
import com.example.huango.infrastructure.readmodel.query.ActivityByPageQuery;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityFinderImpl implements ActivityFinder {


    @Override
    public List<ActivityDTO> queryActivityByPage(ActivityByPageQuery query) {
        BooleanBuilder builder = new BooleanBuilder();
        QActivity qActivity = QActivity.activity;
        if (query.getId() != null){
            builder.and(qActivity.id.eq(query.getId()));
        }
        if (query.getCode() != null){
            builder.and(qActivity.code.eq(query.getCode()));
        }
        if (query.getName() != null){
            builder.and(qActivity.name.eq(query.getName()));
        }
        if (query.getEndTime() !=null ){
            builder.and(qActivity.startTime.after(query.getStartTime()));
        }
        if (query.getEndTime() != null){
            builder.and(qActivity.startTime.before(query.getEndTime()));
        }

        


        return null;
    }


}

package com.example.huango.infrastructure.readmodel.finder;

import com.example.huango.infrastructure.readmodel.dto.ActivityDTO;
import com.example.huango.infrastructure.readmodel.query.ActivityByPageQuery;

import java.util.List;

public interface ActivityFinder {


    List<ActivityDTO> queryActivityByPage(ActivityByPageQuery query);
}

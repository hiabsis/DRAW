package com.example.huango.application.handler;

import com.example.huango.application.command.CreateActivityCommand;
import com.example.huango.application.constant.ErrorMessage;
import com.example.huango.domain.Activity;
import com.example.huango.domain.QActivity;
import com.example.huango.domain.repository.ActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class CreateActivityCommandHandler {
    Factory factory = Factory.INSTANCE;
    @Resource
    private ActivityRepository activityRepository;

    @Transactional
    public void handler(CreateActivityCommand command) {

        final String code = command.getCode();
        long count = activityRepository.count(QActivity.activity.code.eq(code));
        if (count > 0) {
            throw new IllegalArgumentException(ErrorMessage.ACTIVITY_CODE_EXISTED);
        }
        Activity activity = new Activity();
        activity.setCode(command.getCode());
        activity.setName(command.getName());
        activity.setEndTime(command.getEndTime());
        activity.setStartTime(command.getStartTime());
        activityRepository.save(activity);
    }


    @Mapper
    public interface Factory {
        Factory INSTANCE = Mappers.getMapper(Factory.class);

        //        @Mappings(@Mapping(source = "code"))
        Activity toActivity(CreateActivityCommand command);
    }


}

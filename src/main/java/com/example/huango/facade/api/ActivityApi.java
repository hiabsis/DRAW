package com.example.huango.facade.api;

import com.example.huango.application.command.CreateActivityCommand;
import com.example.huango.application.handler.CreateActivityCommandHandler;
import com.example.huango.facade.request.CreateActivityRequest;
import com.example.huango.facade.response.ActivityResponse;
import com.example.huango.infrastructure.spring.response.BoolResponse;
import com.example.huango.infrastructure.spring.response.PageDateResponse;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequestMapping("/v1/activity/")
public class ActivityApi {
    @Resource
    private CreateActivityCommandHandler createActivityCommandHandler;

    @GetMapping("test")
    public PageDateResponse<ActivityResponse> queryActivityPage() {
        return null;
    }

    @PostMapping("/save")
    public BoolResponse saveActivity(@RequestBody @Validated CreateActivityRequest createActivityRequest) {
        CreateActivityCommand command = Factory.INSTANCE.toActivityCommand(createActivityRequest);
        createActivityCommandHandler.handler(command);
        return BoolResponse.success;
    }

    @Mapper
    public interface Factory {
        Factory INSTANCE = Mappers.getMapper(Factory.class);

        CreateActivityCommand toActivityCommand(CreateActivityRequest request);
    }
}

package com.bushub.core.reservation.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/schedules")
@RestController
@RequiredArgsConstructor
public class ScheduleController {

  private final ScheduleService scheduleService;

  @GetMapping
  public List<Schedule> readSchedules(@RequestParam(name = "routeId", required = false) Long routeId) {
    if (routeId != null) {
      return scheduleService.readByRouteId(routeId);
    }

    return scheduleService.readAll();
  }
}

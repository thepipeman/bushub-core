package com.bushub.core.reservation.route;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/routes")
@RestController
@RequiredArgsConstructor
public class RouteController {

  private final RouteService routeService;

  @GetMapping
  public List<Route> readRoutes() {
    return routeService.readAll();
  }
}

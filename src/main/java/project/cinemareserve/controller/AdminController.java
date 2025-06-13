package project.cinemareserve.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.cinemareserve.command.MovieRegisterCommand;
import project.cinemareserve.command.ScreeningRegisterCommand;
import project.cinemareserve.command.SeatRegisterCommand;
import project.cinemareserve.service.AdminService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;


    @PostMapping("/registerMovie")
    public ResponseEntity<String> registerMovie(@RequestBody MovieRegisterCommand command) {
        adminService.createMovie(command);
        return ResponseEntity.ok("Successfully registered");
    }

    @DeleteMapping("/deleteMovie{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        adminService.deleteMovie(id);
        return ResponseEntity.ok("Successfully deleted movie with id: " + id);
    }

    @PostMapping("/registerSeat")
    public ResponseEntity<String> registerSeat(@RequestBody SeatRegisterCommand command) {
        adminService.createSeat(command);
        return ResponseEntity.ok("Successfully registered");
    }

    @PostMapping("/registerScreening")
    public ResponseEntity<String> registerScreening(@RequestBody ScreeningRegisterCommand command) {
        adminService.createScreening(command);
        return ResponseEntity.ok("Successfully registered");
    }

}

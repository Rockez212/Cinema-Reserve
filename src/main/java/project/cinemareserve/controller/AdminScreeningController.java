package project.cinemareserve.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.cinemareserve.command.ScreeningRegisterCommand;
import project.cinemareserve.service.ScreeningService;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/screenings")
public class AdminScreeningController {

    private final ScreeningService screeningService;

    @PostMapping()
    public ResponseEntity<String> registerScreening(@RequestBody @Valid ScreeningRegisterCommand command) {
        screeningService.createScreening(command);
        return ResponseEntity.ok("Successfully added screening");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
        return ResponseEntity.ok("Successfully deleted screening with id " + id);
    }
}

package project.cinemareserve.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.cinemareserve.dtos.BookingDto;
import project.cinemareserve.service.BookingService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final BookingService bookingService;


    @GetMapping()
    public ResponseEntity<List<BookingDto>> getAllBooking() {
        return ResponseEntity.ok(bookingService.getAll());
    }

}

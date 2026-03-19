package com.kalebzaki.syncspace.controllers;

import com.kalebzaki.syncspace.dto.CriacaoSalaDTO;
import com.kalebzaki.syncspace.models.Room;
import com.kalebzaki.syncspace.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> findAll() {
        List<Room> rooms = roomService.findAll();
        return ResponseEntity.ok(rooms);
    }

    @PostMapping
    public ResponseEntity<Room> criarSala(@RequestBody CriacaoSalaDTO room) {
        Room createdRoom = roomService.criarSala(room);
        return ResponseEntity.ok(createdRoom);
    }
}

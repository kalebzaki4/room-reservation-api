package com.kalebzaki.syncspace.services;

import com.kalebzaki.syncspace.dto.CriacaoSalaDTO;
import com.kalebzaki.syncspace.models.Room;
import com.kalebzaki.syncspace.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Transactional
    public Room criarSala(CriacaoSalaDTO dados) {
        Room room = new Room();
        room.setNome(dados.nome());
        room.setCapacidade(dados.capacidade());
        room.setLocalidade(dados.localidade());

        return roomRepository.save(room);
    }


}

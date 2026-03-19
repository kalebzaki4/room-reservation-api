package com.kalebzaki.syncspace.repositories;

import com.kalebzaki.syncspace.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}

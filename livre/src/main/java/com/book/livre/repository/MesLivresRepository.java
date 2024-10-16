package com.book.livre.repository;

import com.book.livre.entity.MesLivres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesLivresRepository extends JpaRepository<MesLivres, Long> {


}

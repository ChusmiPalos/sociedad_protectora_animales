package com.spm.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spm.model.Mascota;

public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long> {

	Iterable<Mascota> readMascotaByNombre(String name);

}

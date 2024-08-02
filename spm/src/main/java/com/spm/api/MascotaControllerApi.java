package com.spm.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spm.data.MascotaRepository;
import com.spm.model.Mascota;

@RestController
@RequestMapping(path = "/api/spm", produces = "application/json")
public class MascotaControllerApi {

	@Autowired
	private MascotaRepository mascotaRepo;

	@GetMapping
	public Iterable<Mascota> findAll() {
		return mascotaRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Mascota findById(@PathVariable("id") Long id) {
		Optional<Mascota> optMascota = mascotaRepo.findById(id);
		if (optMascota.isPresent()) {
			return optMascota.get();
		}
		return null;
	}
	
	@GetMapping("/name/{nombre}")
	public Iterable<Mascota> findByName(@PathVariable("nombre") String nombre) {
		String upperNombre = nombre.toUpperCase();
		return mascotaRepo.readMascotaByNombre(upperNombre);
	}
	
	@GetMapping("/younger/{num_page}")
	public Iterable<Mascota> findYounger(@PathVariable("num_page") int num_page){
		int cantidad = 20;
		PageRequest pageRequest = PageRequest.of(num_page, cantidad, Sort.by("fechaNac").descending());
		return mascotaRepo.findAll(pageRequest);
	}
	
	@GetMapping("/pagination/{num_page}")
	public Iterable<Mascota> findAllByPage(@PathVariable("num_page") int num_page){
		PageRequest pageRequest = PageRequest.of(num_page, 5);
		return mascotaRepo.findAll(pageRequest);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Mascota saveMascota(@RequestBody Mascota mascota) {
		Mascota saved = mascotaRepo.save(mascota);
		return saved;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMascota(@PathVariable("id") Long id) {
		mascotaRepo.deleteById(id);
	}
}

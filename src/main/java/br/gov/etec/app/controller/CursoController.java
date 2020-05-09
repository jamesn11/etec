package br.gov.etec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.CursoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.repository.CursoRepository;

@RestController
public class CursoController {
	
	@Autowired
	private CursoRepository repository;
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public void cadastrarCurso(@RequestBody CursoDto dto) {		
		Curso curso = this.transformarDtoEntity(dto);		
		repository.save(curso);
	}
	
	@RequestMapping("/listarcursos")
	public List<Curso> listarCursos(){
		//Log.info("listando todos cursos da base de dados");
		return repository.findAll();
	}
	
	//Mapping
	private Curso transformarDtoEntity(CursoDto dto) {
		Curso c = new Curso();
		c.setNome(dto.getNome());
		c.setDescricao(dto.getDescricao());
		return c;
	}
}

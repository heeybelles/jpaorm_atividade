package br.edu.fatecpg.fatec;

import br.edu.fatecpg.fatec.model.Aluno;
import br.edu.fatecpg.fatec.model.ReceitasEmPromocao;
import br.edu.fatecpg.fatec.repository.AlunoRepository;
import br.edu.fatecpg.fatec.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class FatecApplication implements CommandLineRunner {
@Autowired
	private AlunoRepository rep;

@Autowired
	private ReceitaRepository repo;
	public static void main(String[] args) {SpringApplication.run(FatecApplication.class, args);}


	@Override
	public void run(String... args) throws Exception {
/*
		INSERINDO DADOS DO ALUNO
		Aluno a1 = new Aluno("Ana", "129.456.789-00", "ana@gmail.com", "34568");
		Aluno a2 = new Aluno("Mariana", "320.456.789-00", "mariana@gmail.com", "76890");
		Aluno a3 = new Aluno("Raul", "282.456.789-00", "raul@gmail.com", "33322");

		rep.save(a1);
		rep.save(a2);
		rep.save(a3);
*/
		List<Aluno> alunos = rep.findAll();
		//alunos.forEach(System.out::println);

		for (Aluno aluno : alunos) {
			System.out.println("Nome:" + aluno.getNome());
			System.out.println("E-mail:" + aluno.getEmail());
		}

		Optional<Aluno> aluno = rep.findById(1L);

		if (aluno.isPresent()) {
			System.out.println(aluno.get());
		} else {
			System.out.println("Aluno não encontrado");
		}

		rep.deleteById(2L);

		System.out.println("Após deletar:");

		rep.findAll().forEach(System.out::println);

/*
			INSERINDO DADOS DA RECEITA

		ReceitasEmPromocao r1 = new ReceitasEmPromocao();
		r1.setNome("Bolo de Chocolate");
		r1.setCategoria("Doce");
		r1.setPreco(25.0);
		r1.setEmPromocao(true);

		ReceitasEmPromocao r2 = new ReceitasEmPromocao();
		r2.setNome("Lasanha");
		r2.setCategoria("Salgado");
		r2.setPreco(40.0);
		r2.setEmPromocao(false);

		ReceitasEmPromocao r3 = new ReceitasEmPromocao();
		r3.setNome("Torta de Frango");
		r3.setCategoria("Salgado");
		r3.setPreco(30.0);
		r3.setEmPromocao(true);

		ReceitasEmPromocao r4 = new ReceitasEmPromocao();
		r4.setNome("Pudim");
		r4.setCategoria("Doce");
		r4.setPreco(18.0);
		r4.setEmPromocao(false);

		ReceitasEmPromocao r5 = new ReceitasEmPromocao();
		r5.setNome("Pizza Caseira");
		r5.setCategoria("Salgado");
		r5.setPreco(45.0);
		r5.setEmPromocao(true);

		repo.save(r1);
		repo.save(r2);
		repo.save(r3);
		repo.save(r4);
		repo.save(r5);
*/

		List<ReceitasEmPromocao> receitas = repo.findAll();
		receitas.forEach(System.out::println);

		List<ReceitasEmPromocao> promocoes = repo.findByEmPromocaoTrue();

		for (ReceitasEmPromocao r : promocoes) {
			System.out.println(r.getNome() + " - R$ " + r.getPreco());
		}
	}
}

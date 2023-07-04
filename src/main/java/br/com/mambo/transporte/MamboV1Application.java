package br.com.mambo.transporte;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.com.mambo.transporte.model.Ajudante;
import br.com.mambo.transporte.model.Contato;
import br.com.mambo.transporte.model.Endereco;
import br.com.mambo.transporte.model.Horarios;
import br.com.mambo.transporte.model.Loja;
import br.com.mambo.transporte.model.LojaEntregas;
import br.com.mambo.transporte.model.Motorista;
import br.com.mambo.transporte.model.Origem;
import br.com.mambo.transporte.model.Veiculo;
import br.com.mambo.transporte.model.Viagem;
import br.com.mambo.transporte.repository.ViagemRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MamboV1Application implements CommandLineRunner {
	
	@Autowired
	ViagemRepository viagemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MamboV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("listando ............");
	}
	
	public void salvarViagem(String numero) {

		List<Loja> lojas = new ArrayList<>();
		List<Contato> contatos = new ArrayList<>();
		contatos.add(new Contato("Henrique", "Conferente", "115616516"));
		lojas.add(new Loja("M2", "M2 - Leopoldina",
				new Endereco("Rua Agnes", "546", "0654", "SP", "Osasco", "Lepoldina"),
				contatos));
		
		List<LojaEntregas>  lojasentregas = new ArrayList<>();
		lojasentregas.add(new LojaEntregas(new Loja("M2", "M2 - Leopoldina",
				new Endereco("Rua Agnes", "546", "0654", "SP", "Osasco", "Lepoldina"),
				contatos), "0", "12", "0"));
	
		Motorista motorista = new Motorista("5", "Entony" ,"Entony Carras Marquis", "454546546");
		Veiculo veiculo = new Veiculo("FDC9A50", "vuc", 12);
		Origem origem = new Origem("CD MAMBO", "CD Principal",
				new Endereco("Rua da Bica", "285", "2114056", "SP", "Barueri", "belval"));
		
		Ajudante ajudante = new Ajudante("45", "Samuel","4544");
		
		Horarios data = new Horarios();
		
		Viagem ss = new Viagem(numero, numero, motorista, veiculo, origem, ajudante, lojasentregas, data);
		
		viagemRepository.save(ss);
		
		
		System.out.println("viagem salva");
	}
	
	public void showAllViagemRepository() {

		viagemRepository.findAll().forEach(item -> System.out.println(getItemDetails(item)));
	}
	
	public String getItemDetails(Viagem item) {

		System.out.println("Motorista: " + item.getMotorista().getNomeCompleto() + ", \nPlaca: " + item.getVeiculo().getPlaca() + ", \nIOrigem: "
				+ item.getOrigem().getNome() + ", \nDestino: " + item.getLojas().get(0).getLoja().getNomeLoja());

		return "";
	}


}

package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class Inserir {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negocios");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setCategorias(Arrays.asList(categoria1, categoria2));
		movimentacao.setDescricao("Jogo do Bicho");
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("500.0"));
		movimentacao.setConta(conta);
				
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		em.persist(categoria1);
		em.persist(categoria2);
		
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		
		em.close();
	}

}

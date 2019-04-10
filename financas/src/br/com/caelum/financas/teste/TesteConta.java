package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Bruno");
		conta.setAgencia("1798");
		conta.setBanco("Inter");
		conta.setNumero("0006568");
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		
		em.getTransaction().begin();
		conta = em.find(Conta.class, 1);
		
		em.remove(conta);
		em.getTransaction().commit();
		
		em.close();
		
	}

}

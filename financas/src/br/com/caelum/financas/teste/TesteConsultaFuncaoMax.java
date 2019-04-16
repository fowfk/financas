package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		BigDecimal valorMaximo = (BigDecimal) query.getSingleResult();
		
		
		System.out.println("Valor maximo é igual a: " );
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}

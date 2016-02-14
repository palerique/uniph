package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 *
	 * Salva ou atualiza qualquer entidades.
	 * 
	 * @param entidade
	 * @return
	 */
	T salvarOuAtualizar(T entidade);

	/**
	 * Recupera a entidades por id
	 * 
	 * @param id
	 * @return
	 */
	T buscarPorId(ID id);

	/**
	 * 
	 * Busca todas as entidades
	 * 
	 * @return
	 */
	List<T> buscarTodos();

	/**
	 * Exclui a entidades.
	 * 
	 * @param entidade
	 */
	void excluir(T entidade);

	// Outros m�todos �teis:

	/**
	 * 
	 * Recebe v�rias criterias e as utiliza para fazer uma pesquisa em banco de
	 * dados retornando uma lista de entidades.
	 * 
	 * (... = vararg)
	 * 
	 * @param criteria
	 * @return
	 */
	List<T> buscarPorCriteria(Criterion... criteria);

	/**
	 * Recebe uma inst�ncia de exemplo e
	 * N string com propriedades que 
	 * n�o ser�o utilizadas na consulta.
	 * 
	 * retorna um conjunto de entidades
	 * que sejam parecidas com o exemplo.
	 * 
	 * @param exemplo
	 * @param propriedadesAExcluir
	 * @return
	 */
	List<T> buscarPorExemplo(T exemplo, 
			String... propriedadesAExcluir);
}

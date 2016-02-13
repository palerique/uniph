package br.com.sitedoph.uniph.infraestrutura.persistencia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * 
	 * Salva ou atualiza qualquer entidade.
	 * 
	 * @param entidade
	 * @return
	 */
	T salvarOuAtualizar(T entidade);

	/**
	 * Recupera a entidade por id
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
	 * Exclui a entidade.
	 * 
	 * @param entidade
	 */
	void excluir(T entidade);

	// Outros métodos úteis:

	/**
	 * 
	 * Recebe várias criterias e as utiliza para fazer uma pesquisa em banco de
	 * dados retornando uma lista de entidades.
	 * 
	 * (... = vararg)
	 * 
	 * @param criteria
	 * @return
	 */
	List<T> buscarPorCriteria(Criterion... criteria);

	/**
	 * Recebe uma instância de exemplo e
	 * N string com propriedades que 
	 * não serão utilizadas na consulta.
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
